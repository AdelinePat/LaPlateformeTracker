package utils;

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
    public static final String LOGIN_PATH;
    public static final String REGISTER_PATH;
    public static final String GRADEGRAPH_PATH;
    private static Connection connection = null;

    static {
        dotenv = Dotenv.load();
        URL = dotenv.get("URL");
        USER = dotenv.get("USER");
        PASSWORD = dotenv.get("PASSWORD");
        DASHBOARD_PATH = dotenv.get("DASHBOARD_PATH");
        REGISTER_PATH = dotenv.get("REGISTER_PATH");
        LOGIN_PATH = dotenv.get("LOGIN_PATH");
        GRADEGRAPH_PATH = dotenv.get("GRADEGRAPH_PATH");
    }

    public static Connection databaseOpenConnexion() throws SQLException {
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
