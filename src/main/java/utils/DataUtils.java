package utils;
import javax.security.auth.login.LoginException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    public static boolean isNameValid(String input) {
        String pattern = "^\\p{L}+$";
        return input.matches(pattern);
    }

    public static boolean isInputIntegerValid(String input) {
        return input.matches("^\\d+$");
    }

    public static boolean isInputFloatValid(String input) {
        return input.matches("^\\d+\\.\\d+$") || isInputIntegerValid(input);
    }

    public static boolean isInputEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
