package DAO;

import utils.DatabaseConnection;
import javax.security.auth.login.LoginException;
import java.sql.*;
import java.util.List;

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
                        throw new LoginException("Une erreur est survenue plusieurs utilisateurs" +
                                "ont été trouvé avec ce nom : " + userName);
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
                    throw new LoginException("Une erreur est survenue aucun utilisateur " +
                            "n'a été trouvé avec les données entrées");
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
}
