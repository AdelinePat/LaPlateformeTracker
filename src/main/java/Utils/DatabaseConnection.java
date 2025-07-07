package Utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final Dotenv dotenv;
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    public static final String DASHBOARD_PATH;
    private static Connection connection = null;

    static {
        dotenv = Dotenv.load();
        URL = dotenv.get("URL");
        USER = dotenv.get("USER");
        PASSWORD = dotenv.get("PASSWORD");
        DASHBOARD_PATH = dotenv.get("DASHBOARD_PATH");
    }

    public static Connection databaseOpenConnexion() throws SQLException {
        System.out.println(URL + " " + USER + " " + PASSWORD);
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Database connection opened.");
        }
        return connection;
    }

    public static void databaseCloseConnexion() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
