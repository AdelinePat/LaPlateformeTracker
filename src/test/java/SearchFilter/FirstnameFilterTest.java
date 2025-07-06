package SearchFilter;
import Utils.StudentObject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FirstnameFilterTest {
    FirstnameFilter filter = new FirstnameFilter();

    @Test
    public void filterRequestTest() {
        List<StudentObject> students = filter.filterRequest();
        assertThat(students.isEmpty(), equalTo(false));
    }
}
