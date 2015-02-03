import Dome.Dome;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by hu on 15-2-2.
 */
public class DameTest {
    @Test
    public void should_return_string_hi(){
        Dome dome = new Dome();
        String result = dome.say();
        assertThat(result).isEqualTo("hi");
    }


}
