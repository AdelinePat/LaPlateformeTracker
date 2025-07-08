package Utils;

import SearchFilter.SearchFilter;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserObjectTest {
    UserObject user = new UserObject();

    @Test
    public void hashPasswordTest() throws Exception {
        byte[] salt = user.generateSalt();
        user.setUserName("user1");
        user.setPassword("password1");
        user.hashPassword(salt);
    }

    @Test
    public void loginTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
        user.setUserName("user1");
        user.setPassword("pasSWWord1*");
        boolean value = user.login();
    }

    @Test
    public void generateSalt() {
        user.generateSalt();
    }
}


