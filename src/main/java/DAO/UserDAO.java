package DAO;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static void addUser(List<String> userRequest) {
    }

    public static void deleteUser(List<String> userRequest) {
    }

    public static boolean doesUserExist(String userName) {
        return false;
    }

    public static boolean doesPasswordMatch(String userName, String password) {
        return false;
    }
}
