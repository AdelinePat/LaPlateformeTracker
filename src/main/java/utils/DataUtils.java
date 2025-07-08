package utils;
import javax.security.auth.login.LoginException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    public static boolean isNameNotValid(String input) throws LoginException {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        String pattern = "^[\\p{L}]+$";
        return !input.matches(pattern);
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

    public static List<String> parsingFilterRequest(String requestContent) {
        return new ArrayList<>();
    }

    public static StudentObject parseIntoStudentObject(ResultSet aRequestResult) {
        return new StudentObject();
    }

    public static List<StudentObject> parseIntoStudentObjectList(ResultSet requestResult) {
        return new ArrayList<>();
    }
}
