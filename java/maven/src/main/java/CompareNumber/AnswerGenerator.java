package CompareNumber;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by hu on 15-2-3.
 */
public class AnswerGenerator {
   /* int number1;
    int number2;
    int number3;
    public String show() {
         int a= (int) (Math.random()*100);
        return "1234";
    }*/
    private final ArrayList<String> historyGenerateNumbers;
    private Random random;
    public AnswerGenerator(Random random){
        this.historyGenerateNumbers=new ArrayList<String>();
        this.random=random;
    }

    public String generate() {
        String digit=generateOnce();
        while (historyGenerateNumbers.contains(digit)){
            digit=generateOnce();
        }
        if(historyGenerateNumbers.size()==2){
            historyGenerateNumbers.remove(0);
        }
        historyGenerateNumbers.add(digit);
        return digit;
    }

    private String generateOnce() {
        StringBuilder digits = new StringBuilder();
        while(digits.length()<4){
            String num=String.valueOf(random.nextInt(10));
            if(digits.indexOf(num)==-1){
                digits.append(num);
            }
        }
        return digits.toString();
    }
}
