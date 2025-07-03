package Utils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {
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
