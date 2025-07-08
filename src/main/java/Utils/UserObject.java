package Utils;

import DAO.UserDAO;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class UserObject {
    private String userName;
    private String password;
    public List<Integer> ageRange;
    public List<Integer> gradeRange;
    public String FirstnameFilter;
    public String LastnameFilter;

    public boolean login() {
        return UserDAO.doesUserExist(this.userName) && UserDAO.doesPasswordMatch(this.userName, this.password);
    }

    public byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        // System.out.println("random: " + random);
        byte[] salt = new byte[16];
        // System.out.println("Salt: " + salt.length);
        random.nextBytes(salt);
        //System.out.println("random: " + random);
        return salt;
    }
    public void hashPassword() throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println("Password: " + this.password);
        byte[] salt = generateSalt();
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
}
