package CompareNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by hu on 15-2-5.
 */
public class Game {
    private PrintStream out;
    private final BufferedReader reader;
    private final AnswerGenerator numberGenerator;
    private final CompareNumber compareNumber;

    public Game(PrintStream out, BufferedReader reader, AnswerGenerator numberGeneerator, CompareNumber compareNumber) {
             this.out=out;
        this.reader = reader;
        this.numberGenerator = numberGeneerator;
        this.compareNumber = compareNumber;
    }
    public void start() throws IOException {
        int chance=6;
        out.println("Welcome!");
        while(chance>0){
            out.println("Please input your answer("+chance+"):");
            String input =numberGenerator.generate();
            String answer=reader.readLine();
            String result=compareNumber.show(input,answer);
            if ("4A0B".equals(result)){
                out.println("Congratulations!");
                return;
            }
            out.println(result);
            chance--;
        }
        out.println("Game Over!");


    }
}
