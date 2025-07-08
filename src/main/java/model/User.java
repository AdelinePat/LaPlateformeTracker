package model;

import DAO.UserDAO;
import utils.DatabaseConnection;

import javax.security.auth.login.LoginException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String userName;
    private String password;
    private Salt salt = null;
    public List<Integer> ageRange;
    public List<Integer> gradeRange;
    public String FirstnameFilter;
    public String LastnameFilter;

    public boolean login() throws NoSuchAlgorithmException, InvalidKeySpecException, LoginException, SQLException {
        if(UserDAO.doesUserExist(this.userName)) {
            String salt = getSaltFromDatabase(this.userName);
            this.salt = new Salt(salt);
//            byte[] salt = getSaltFromDatabase(this.userName);
            this.password = this.salt.hashPassword(this.password);

            System.out.println("login after hashpassword : " + this.password);
            return UserDAO.doesPasswordMatch(this.userName, this.password);
        } else {
            throw new LoginException("ce nom d'utilisateur n'a pas été trouvé");
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    private String getSaltFromDatabase(String userName) throws SQLException {
        String query = "SELECT salt FROM staff WHERE username = ?";
        Connection conn = DatabaseConnection.databaseOpenConnexion();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, userName); // match firstnames starting with input
        StringBuilder salt = new StringBuilder();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            salt.append(rs.getString(1));
        } else {
            throw new SQLException("les données de cet utilisateur n'ont pas été trouvé");
        }
        rs.close();
        ps.close();
        DatabaseConnection.databaseCloseConnexion();

        return salt.toString();
    }


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

    public boolean canRegister() throws LoginException, NoSuchAlgorithmException, InvalidKeySpecException {
        if (!UserDAO.doesUserExist(this.getUserName())) {
            if (this.isRegexPasswordValid(this.getPassword())) {
                this.salt = new Salt();
                this.setPassword(this.salt.hashPassword(this.getPassword()));
                return true;
            }
        } else {
            throw new LoginException("cet utilisateur existe déjà");
        }
        return true;
    }

    public void register() throws LoginException, NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
        if(this.canRegister()){
            String query = "INSERT INTO staff (username, password, salt) VALUES (?, ?, ?)";

            Connection conn = DatabaseConnection.databaseOpenConnexion();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, this.getUserName());
            ps.setString(2, this.getPassword());
            ps.setString(3, this.salt.getReadableSalt());
            ps.executeUpdate();

            ps.close();
            DatabaseConnection.databaseCloseConnexion();

        }
    }

}
