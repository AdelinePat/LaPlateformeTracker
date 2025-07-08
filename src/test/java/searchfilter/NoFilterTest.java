package searchfilter;

import model.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NoFilterTest {
    NoFilter filter = new NameFilter();

    @Test
    public void filterRequestTest() {
        List<Student> students = filter.getInitialStudentList();
        assertThat(students.isEmpty(), equalTo(false));
    }
}
