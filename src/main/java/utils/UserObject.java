package utils;

import DAO.UserDAO;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.security.auth.login.LoginException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

public class UserObject {
    private String userName;
    private String password;
    private String salt;
    public List<Integer> ageRange;
    public List<Integer> gradeRange;
    public String FirstnameFilter;
    public String LastnameFilter;


    public boolean login() throws NoSuchAlgorithmException, InvalidKeySpecException, LoginException, SQLException {
        if(UserDAO.doesUserExist(this.userName)) {
            byte[] salt = getSaltFromDatabase(this.userName);
            this.hashPassword(salt);
            return UserDAO.doesPasswordMatch(this.userName, this.password);
        } else {
            throw new LoginException("ce nom d'utilisateur n'a pas été trouvé");
        }
    }

    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public String encodeSalt(byte[] salt) {
        return Base64.getEncoder().encodeToString(salt);
    }

    public byte[] decodeSalt(String encodedSalt) {
        return Base64.getDecoder().decode(encodedSalt);
    }

    public void hashPassword(byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println("Password: " + this.password);
//        byte[] salt = generateSalt();
        KeySpec spec = new PBEKeySpec(this.password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        this.password = Base64.getEncoder().encodeToString(hash);
        System.out.println("Password hashed: " + this.password);
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

    public String getSalt() {
        return salt;
    }

    private byte[] getSaltFromDatabase(String userName) throws SQLException {
        String query = "SELECT salt FROM staff WHERE username = ?";
        Connection conn = DatabaseConnection.databaseOpenConnexion();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, userName); // match firstnames starting with input

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            this.salt = rs.getString(1);
        } else {
            throw new SQLException("les données de cet utilisateur n'ont pas été trouvé");
        }
        rs.close();
        ps.close();
        DatabaseConnection.databaseCloseConnexion();

        return this.decodeSalt(this.salt);
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
