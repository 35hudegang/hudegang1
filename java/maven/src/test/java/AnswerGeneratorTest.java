import CompareNumber.AnswerGenerator;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;



import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by hu on 15-2-3.
 */
public class AnswerGeneratorTest {
   /* @Test
    public void Answer_return_int_out_repeat() {
        AnswerGenerator answerGenerator = new AnswerGenerator();
        int result = answerGenerator.show();
        String result1 = "yes";
        int[] number = new int[4];
        number[0] = result % 10;
        number[1] = result / 10 % 10;
        number[2] = result / 100 % 10;
        number[3] = result / 1000;
        int number1;
        for (int i = 0; i < number.length; i++) {
            number1 = number[i];
            for (int j = i+1; j < number.length; j++) {
                if (number[i]== number[j]) {
                    result1 = "no";
                    break;
                }
            }
        }

        assertThat(result1).isEqualTo("yes");
    }*/
    @Test
    public void should_be_a_digit(){
        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());
        String digit=answerGenerator.generate();
        try {
            Integer.parseInt(digit);
        }catch (NumberFormatException e){
            fail("result should be a number.");
        }


    }
    @Test
    public void should_be_a_4_digit(){
        AnswerGenerator answerGenerator = new AnswerGenerator(new Random());
        String digit=answerGenerator.generate();
         assertThat(digit.length()).isEqualTo(4);

    }
    @Test
    public void should_generate_no_duplicate_digit(){
        String digit=new AnswerGenerator(new Random()).generate();
        for(int x=0; x<digit.length(); x++){
            char ch=digit.charAt(x);
            assertThat(digit.indexOf(ch)).isEqualTo(digit.lastIndexOf(ch));
        }
    }
    @Test
    public void should_repeat_in_3_times(){
        Random random=mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(1, 2, 3, 4)
                .willReturn(2, 3, 4, 5)
                .willReturn(3, 4, 5, 6);
        AnswerGenerator answerGenerator=new AnswerGenerator(random);
        HashSet<String> digits=new HashSet<String>();
        digits.add(answerGenerator.generate());
        digits.add(answerGenerator.generate());
        digits.add(answerGenerator.generate());
        assertThat(digits.size()).isEqualTo(3);

    }
    @Test
    public void should_not_repeat_in_3_times(){
        Random random=mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(1, 2, 3, 4)
                .willReturn(2, 3, 4, 5)
                .willReturn(3, 4, 5, 6);
        AnswerGenerator answerGenerator=new AnswerGenerator(random);
        HashSet<String> digits=new HashSet<String>();
        digits.add(answerGenerator.generate());
        digits.add(answerGenerator.generate());
        digits.add(answerGenerator.generate());
        assertThat(digits.size()).isEqualTo(3);

    }
    @Test
    public void should_be_able_to_repeat_out_of_3_times(){
        Random random=mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1, 2, 3, 4)
                .willReturn(1, 5, 3, 4)
                .willReturn(2, 3, 4, 5)
                .willReturn(1, 2, 3, 4);
        AnswerGenerator answerGenerator=new AnswerGenerator(random);
        HashSet<String> digits=new HashSet<String>();
        digits.add(answerGenerator.generate());
        digits.add(answerGenerator.generate());
        digits.add(answerGenerator.generate());
        digits.add(answerGenerator.generate());
        assertThat(digits.size()).isEqualTo(3);

    }
   /*
    @Test
    public void answer_string_length_4(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        String num="no";
        String result=answerGenerator.show();
        if (result.length()==4){
           num="ok";
        }
        Assertions.assertThat("ok").isEqualTo(num);
    }
    public  void  Answer_return_int_out_repeat(){
        AnswerGenerator answerGenerator = new AnswerGenerator();
        String result=answerGenerator.show();
        for (int i = 0; i < result.length(); i++) {
            
        }
    }
*/
}
