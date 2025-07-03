package DAO;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static Connexion databaseOpenConnexion() {
        return new Connexion();
    }

    public static void databaseCloseConnexion() {
    }

    public static void createUser(List<String> userRequest) {
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
