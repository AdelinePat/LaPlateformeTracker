package SearchFilter;

import Utils.StudentObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchFilterTest {
    SearchFilter filter = new NameFilter();

    @Test
    public void filterRequestTest() {
        List<StudentObject> students = filter.getInitialStudentList();
        assertThat(students.isEmpty(), equalTo(false));
    }
}
