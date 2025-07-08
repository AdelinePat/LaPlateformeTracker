package searchfilter;
import model.Student;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NameFilterTest {
    ISearchFilter filter = FilterFactory.createFilter(FilterType.FIRSTNAME);

    @Test
    public void getFilteredStudentListTest() throws Exception {
        FilterCommand command = new FilterCommand();
        command.setType(FilterType.FIRSTNAME);
        command.setSearchString("Jo");
        List<Student> students = filter.getFilteredStudentList(command);
        assertThat(students.isEmpty(), equalTo(false));
    }
}
