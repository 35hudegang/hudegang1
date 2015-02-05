import CompareNumber.AnswerGenerator;
import CompareNumber.CompareNumber;
import CompareNumber.Game;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;

/**
 * Created by hu on 15-2-5.
 */
public class GameTest {
    private PrintStream out;
    private Game game;
    private InOrder inOrder;
    private BufferedReader reader;
    private AnswerGenerator numberGenerator;
    private  CompareNumber compareNumber;

    /* @Test
        public void game_out_welcome(){
            String num=mock(String.class);
            given(num)
                    .willReturn("welcome!");
            Game game = new Game(num);
            game.compareNumber();
        }*/
   @Before
   public void  set_up() throws IOException {
       out = mock(PrintStream.class);
       reader=mock(BufferedReader.class);
       numberGenerator=mock(AnswerGenerator.class);
       compareNumber = new CompareNumber();
       given(reader.readLine()).willReturn("1234");
       given(numberGenerator.generate()).willReturn("4321");
       game = new Game(out,reader,numberGenerator,compareNumber);
       inOrder = inOrder(out);
   }
    @Test
    public void should_print_welcome_first_when_game_start() throws IOException {
        verify(out ,never()).println("Welcome!");
        game.start();
        verify(out).println("Welcome!");
    }
    @Test
    public void should_print_please_input_your_answer_second_when_game_start() throws IOException {
        game.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6):");
    }
    @Test
    public void should_print_compare_result_when_answer_is_wrong() throws IOException {



        game.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6):");
        inOrder.verify(out).println("0A4B");
    }
    @Test
    public void should_reduce_chance_one_when_answer_is_wrong() throws IOException {

        game.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(5):");
    }
    @Test
    public void reduce_chance_one_by_one_when_chance_is_0_game_over() throws IOException {

        game.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(5):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(4):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(3):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(2):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(1):");

        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Game Over!");
        inOrder.verify(out,never()).println("0A4B");


    }
    @Test
    public void should_congratulation_when_answer_is_right_first() throws IOException {
        given(reader.readLine()).willReturn("4321");
        game.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6):");
        inOrder.verify(out).println("Congratulations!");
        inOrder.verify(out,never()).println("4A0B");
        inOrder.verify(out,never()).println("Please input your answer(5):");
    }

    @Test
    public void should_congratulation_when_answer_is_right_second() throws IOException {
        given(reader.readLine()).willReturn("6432","4321");
        game.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6):");

        inOrder.verify(out).println("Congratulations!");
        inOrder.verify(out,never()).println("4A0B");
        inOrder.verify(out,never()).println("Please input your answer(1):");
    }
    @Test
    public void should_congratulation_when_answer_is_right_last() throws IOException {
        given(reader.readLine()).willReturn("1234","1234","1234","1234","1234","4321");
        game.start();
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(5):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(4):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(3):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(2):");
        inOrder.verify(out).println("0A4B");
        inOrder.verify(out).println("Please input your answer(1):");
        inOrder.verify(out).println("Congratulations!");
        inOrder.verify(out,never()).println("4A0B");
        inOrder.verify(out,never()).println("Game Over!");
    }

}
