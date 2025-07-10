package searchfilter;

import model.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NoFilterTest {
    ISearchFilter filter = FilterFactory.createFilter(FilterType.NOFILTER);
    FilterCommand command = new FilterCommand();

    @Test
    public void filterRequestTest() throws Exception {
        command.setType(FilterType.NOFILTER);
        List<Student> students = filter.getFilteredStudentList(command);
        assertThat(students.isEmpty(), equalTo(false));
    }
}
