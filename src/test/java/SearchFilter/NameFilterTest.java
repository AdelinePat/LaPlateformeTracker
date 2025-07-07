package SearchFilter;
import Utils.StudentObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NameFilterTest {
    SearchFilter filter = new NameFilter();

    @Test
    public void getInitialStudentListTest() {
        List<StudentObject> students = filter.getInitialStudentList();
        assertThat(students.isEmpty(), equalTo(false));
    }

    @Test
    public void getFilteredStudentListTest() {
        List<StudentObject> students = filter.getFilteredStudentList("firstname", "Jo");
        assertThat(students.isEmpty(), equalTo(false));
    }
}
