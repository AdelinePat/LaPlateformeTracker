package model;

import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    User user = new User();

    @Test
    public void loginTest() throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException, LoginException {
        user.setUserName("jolyne");
        user.setPassword("Aa123456!!");
        assertTrue(user.login());
    }


}


