import CompareNumber.CompareNumber;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by hu on 15-2-3.
 */
public class CompareGeneratorTest {
    @Test
    public void compare_return_String_0A0B(){
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.show("1234","5678");
        assertThat(result).isEqualTo("0A0B");

    }
    @Test
    public void compare_return_String_0A4B(){
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.show("1234", "4321");
        assertThat(result).isEqualTo("0A4B");
    }
    @Test
    public void compare_return_String_2A1B(){
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.show("1234", "1832");
        assertThat(result).isEqualTo("2A1B");
    }
    @Test
    public void compare_return_String_4A0B(){
        CompareNumber compareNumber = new CompareNumber();
        String result = compareNumber.show("1234","1234");
        assertThat(result).isEqualTo("4A0B");
    }

}
