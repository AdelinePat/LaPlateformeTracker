package searchfilter;

import model.Student;

import java.util.List;

public interface ISearchFilter {
    public List<Student> getFilteredStudentList(FilterCommand filterCommand) throws Exception;
}