package SearchFilter;

import Utils.StudentObject;

import java.util.ArrayList;
import java.util.List;

public class AgeFilter extends SearchFilter {
    @Override
    public List<StudentObject> getFilteredStudentList(String columnName, String contentRequest) {
        List<StudentObject> filteredList = new ArrayList<>();
        return filteredList;
    }
}
