package searchfilter;

import exceptions.FilterException;
import model.Student;

import java.util.List;

public interface ISearchFilter {
    public List<Student> getFilteredStudentList(FilterCommand filterCommand) throws FilterException;
}