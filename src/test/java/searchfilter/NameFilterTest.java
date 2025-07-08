package searchfilter;
import utils.StudentObject;
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
    public void getFilteredStudentListTest() throws Exception {
        FilterCommand command = new FilterCommand();
        command.setType(FilterType.FIRSTNAME);
        command.setSearchString("Jo");
        List<StudentObject> students = filter.getFilteredStudentList(command);
        assertThat(students.isEmpty(), equalTo(false));
    }
}
