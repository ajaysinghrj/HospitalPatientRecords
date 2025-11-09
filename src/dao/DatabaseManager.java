package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:hospital.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC"); // ensure driver loads
            try (Connection con = getConnection(); Statement st = con.createStatement()) {
                st.execute("""
                    CREATE TABLE IF NOT EXISTS patients(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        age INTEGER NOT NULL,
                        disease TEXT NOT NULL
                    )
                """);
                System.out.println("✅ Database and table ready!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL);
    }
}
