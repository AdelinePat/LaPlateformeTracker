package DAO;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    protected static final Dotenv dotenv = Dotenv.load();
    protected static final String URL = dotenv.get("URL");
    protected static final String USER = dotenv.get("USER");
    protected static final String PASSWORD = dotenv.get("PASSWORD");
    private static Connection connection = null;

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
      
    public static Connexion databaseOpenConnexion() {
        return new Connexion();
    }

    public static void databaseCloseConnexion() {
      
    }

    public static void createUser(List<String> userRequest) {
    }

    public static void deleteUser(List<String> userRequest) {
    }

    public static boolean doesUserExist(String userName) {
        return false;
    }

    public static boolean doesPasswordMatch(String userName, String password) {
        return false;
    }
}
