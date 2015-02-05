package CompareNumber;

import java.io.PrintStream;

/**
 * Created by hu on 15-2-5.
 */
public class Game {
    private PrintStream out;

    public Game(PrintStream out) {
    this.out=out;
    }
    public void start() {
        System.out.print("Welcome!");
        out.println("Please input your answer(6):");
    }
}
