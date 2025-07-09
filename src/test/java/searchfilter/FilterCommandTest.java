package searchfilter;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class FilterCommandTest {
    FilterCommand command = new FilterCommand();

    @Test
    public void setAgeValuesTest(){
        command.setAgeValues("13", "12");
        assertThat(command.getMaxAgeValue(), greaterThan(command.getMinAgeValue()));
    }

    @Test
    public void setGradeValuesTest(){
        command.setGradeValues("12.5", "12.1");
        assertThat(command.getMaxGradeValue(), greaterThan(command.getMinGradeValue()));
    }
}
