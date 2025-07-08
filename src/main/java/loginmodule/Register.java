package loginmodule;

import DAO.UserDAO;
import utils.DatabaseConnection;
import utils.UserObject;

import javax.security.auth.login.LoginException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {

    public boolean isRegexPasswordValid(String password) throws LoginException {
        String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&_])[A-Za-z\\d@$!%*#?&]{10,}$";
        Pattern pattern = Pattern.compile(passwordRegex);

        Matcher match = pattern.matcher(password);

        if (match.matches()) {
            System.out.println("Password is valid");
            return match.matches();
        } else {
            throw new LoginException("Le mot de passe doit contenir au moins une minuscule, " +
                    "une majuscule et un caractère spécial (@$!%*#?&) " +
                    "et doit faire au moins 10 caractères.");
        }
    }

    public boolean canRegister(UserObject user) throws LoginException, NoSuchAlgorithmException, InvalidKeySpecException {
        if (!UserDAO.doesUserExist(user.getUserName())) {
            if (this.isRegexPasswordValid(user.getPassword())) {
                byte[] salt = user.generateSalt();
                user.setSalt(user.encodeSalt(salt));
                user.hashPassword(salt);
                return true;
            }
        } else {
            throw new LoginException("cet utilisateur existe déjà");
        }
        return true;
    }

    public void register(UserObject user) throws LoginException, NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        if(this.canRegister(user)){
            String query = "INSERT INTO staff (username, password, salt) VALUES (?, ?, ?)";

            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSalt());
            ps.executeUpdate();

            ps.close();
            DatabaseConnection.databaseCloseConnexion();

//            catch (SQLException e) {
//                System.out.println("User couldn't be added: " + e.getMessage());
//            }
        }
    }
}
