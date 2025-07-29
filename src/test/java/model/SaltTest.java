package model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SaltTest {
    Salt salt = new Salt("dMkUiLpMqk6zhhi7FsBkHg==");

    @Test
    public void hashPasswordTest() throws Exception {
        String password = salt.hashPassword("Abcd*123456");
        assertThat(password, equalTo("aEM4VBS0f6YqyQe/EywELg=="));
//        assertThat(password, equalTo("aEM4VBS0f6YqegyQe/EywELg=="));
    }
}