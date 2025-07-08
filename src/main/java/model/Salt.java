package model;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Salt {
    private byte[] byteListSalt;

    public Salt() {
        this.byteListSalt = generateSalt();
    }
    public Salt(String salt) {
        this.byteListSalt = Base64.getDecoder().decode(salt);
    }

    public String getReadableSalt() {
        return Base64.getEncoder().encodeToString(this.byteListSalt);
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        System.out.println("generateSalt : " + salt);
        return salt;
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println("Password: " + password);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), this.byteListSalt, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] hashedPassword = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
}
