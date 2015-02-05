import CompareNumber.AnswerGenerator;
import CompareNumber.Game;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.HashSet;

/**
 * Created by hu on 15-2-5.
 */
public class GameTest {
   /* @Test
    public void game_out_welcome(){
        String num=mock(String.class);
        given(num)
                .willReturn("welcome!");
        Game game = new Game(num);
        game.compareNumber();
    }*/
    @Test
    public void should_print_welcome_first_when_game_start(){
        PrintStream out = mock(PrintStream.class);
        Game game=new Game(out);
        verify(out ,never()).print("Welcome!");
        game.start();
        verify(out).println("Welcome!");
    }
    @Test
    public void should_print_please_input_your_answer_second_when_game_start(){
        PrintStream out = mock(PrintStream.class);
        Game game=new Game(out);
        game.start();
        InOrder inOrder=inOrder(out);
        inOrder.verify(out).println("Welcome!");
        inOrder.verify(out).println("Please input your answer(6):");
    }

}
