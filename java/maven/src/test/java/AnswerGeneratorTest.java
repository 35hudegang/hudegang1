import CompareNumber.AnswerGenerator;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by hu on 15-2-3.
 */
public class AnswerGeneratorTest {
    @Test
    public void AnswerGenerator(){
        int num=1000;
        String result="yes";
        int[] number=new int[num];
        AnswerGenerator answerGenerator = new AnswerGenerator();
        for (int i = 0; i <num; i++) {
            number[i]=answerGenerator.show();
        }
        for (int i = 2; i <num; i++) {
            if(number[i]==number[i-1]&&number[i]==number[i-2]){
               result="no";
                break;
            }
        }
        Assertions.assertThat(result).isEqualTo("yes");
    }


}
