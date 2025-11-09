package mainapp;
import javax.swing.SwingUtilities;
import service.ThreadedBackupManager;
import ui.MainFrame;

public class App {
    public static void main(String[] args) {
        ThreadedBackupManager t = new ThreadedBackupManager();
        t.start();

        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}