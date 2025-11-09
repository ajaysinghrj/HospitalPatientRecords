package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import dao.DatabaseManager;
import model.Patient;

public class DataHandler {

    // Save a patient into the SQLite database
    public static void saveToDatabase(Patient p) {
        String sql = "INSERT INTO patients (name, age, disease) VALUES (?, ?, ?)";

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getDisease());
            ps.executeUpdate();

            System.out.println("✅ Patient record saved successfully to DB!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
