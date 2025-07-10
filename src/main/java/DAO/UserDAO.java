package DAO;

import model.User;
import utils.DatabaseConnection;
import javax.security.auth.login.LoginException;
import java.sql.*;
import java.util.List;

import static exceptions.ExceptionMessage.*;

public class UserDAO {
    public static void addUser(List<String> userRequest) {
    }

    public static void deleteUser(List<String> userRequest) {
    }

    public static boolean doesUserExist(String userName) {
        String query = "SELECT COUNT(*) FROM staff WHERE username = ?";
        boolean result = false;
        try {
            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                switch (count) {
                    case 0:
                        result = false;
                        break;
                    case 1:
                        result = true;
                        break;
                    default:
                        rs.close();
                        ps.close();
                        throw new LoginException(MULTIPLE_USERS_FOUND.getMessage());
                }
            }
            rs.close();
            ps.close();
            DatabaseConnection.databaseCloseConnexion();
        } catch (SQLException | LoginException e) {
            System.out.println("SQL Error during name filtering: " + e.getMessage());
        }
        return result;
    }

    public static boolean doesPasswordMatch(String userName, String password) throws SQLException, LoginException{
        String query = "SELECT COUNT(*) FROM staff WHERE username = ? AND password = ?";
        boolean result = false;

        Connection conn = DatabaseConnection.databaseOpenConnexion();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, userName);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            switch (count) {
                case 1:
                    result = true;
                    break;
                default:
                    rs.close();
                    ps.close();
                    throw new LoginException(LOGIN_ERROR.getMessage());
            }
        }
        rs.close();
        ps.close();
        DatabaseConnection.databaseCloseConnexion();
//        catch (SQLException | LoginException e) {
//            System.out.println("SQL Error during name filtering: " + e.getMessage());
//        }
        return result;
    }

    public static void createUser(User user) throws SQLException {
        String query = "INSERT INTO staff (username, password, salt) VALUES (?, ?, ?)";
        Connection conn = DatabaseConnection.databaseOpenConnexion();
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getReadableSalt());
        ps.executeUpdate();

        ps.close();
        DatabaseConnection.databaseCloseConnexion();
    }

    public static String getSaltFromDatabase(String userName) throws SQLException {
        String query = "SELECT salt FROM staff WHERE username = ?";
        Connection conn = DatabaseConnection.databaseOpenConnexion();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, userName); // match firstnames starting with input
        StringBuilder salt = new StringBuilder();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            salt.append(rs.getString(1));
        } else {
            throw new SQLException(USERDATA_NOT_FOUND.getMessage());
        }
        rs.close();
        ps.close();
        DatabaseConnection.databaseCloseConnexion();

        return salt.toString();
    }


}
