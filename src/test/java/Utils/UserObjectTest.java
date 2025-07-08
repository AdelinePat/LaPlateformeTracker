package Utils;

import SearchFilter.SearchFilter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserObjectTest {
    UserObject user = new UserObject();

    @Test
    public void hashPasswordTest() throws Exception {
        user.setUserName("user1");
        user.setPassword("password1");
        user.hashPassword();
    }

    @Test
    public void generateSalt() {
        user.generateSalt();
    }
}


