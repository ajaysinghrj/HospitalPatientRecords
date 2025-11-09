package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Patient;
import service.DataHandler;
import dao.DatabaseManager;
import java.awt.*;
import java.sql.*;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L; // ✅ Fixed warning

    public MainFrame() {
        setTitle("Hospital Patient Records");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // ---- Input fields ----
        JTextField nameField = new JTextField(15);
        JTextField ageField = new JTextField(5);
        JTextField diseaseField = new JTextField(10);
        JButton saveBtn = new JButton("Save");
        JButton viewBtn = new JButton("View All Patients");
        JButton clearBtn = new JButton("Clear All Data"); // new button

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Disease:"));
        panel.add(diseaseField);
        panel.add(saveBtn);
        panel.add(viewBtn);
        panel.add(clearBtn);
        add(panel);

        // ---- Save button ----
        saveBtn.addActionListener(e -> {
            try {
                Patient p = new Patient(0, nameField.getText(),
                        Integer.parseInt(ageField.getText()),
                        diseaseField.getText());
                DataHandler.saveToDatabase(p);
                JOptionPane.showMessageDialog(this, "Saved to Database Successfully!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error while saving: " + ex.getMessage());
            }
        });

        // ---- View button ----
        viewBtn.addActionListener(e -> {
            try (Connection con = DatabaseManager.getConnection();
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM patients")) {

                DefaultTableModel model = new DefaultTableModel(
                        new Object[]{"ID", "Name", "Age", "Disease"}, 0);

                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("disease")
                    });
                }

                JTable table = new JTable(model);
                JOptionPane.showMessageDialog(this, new JScrollPane(table), "All Patients",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error fetching data: " + ex.getMessage());
            }
        });

        // ---- Clear button ----
        clearBtn.addActionListener(e -> {
            nameField.setText("");
            ageField.setText("");
            diseaseField.setText("");
        });
    }
}
