package cleancode.studycafe.mine;

import cleancode.studycafe.mine.io.ConsoleInputHandler;
import cleancode.studycafe.mine.io.ConsoleOutputHandler;
import cleancode.studycafe.mine.io.InputHandler;
import cleancode.studycafe.mine.io.OutputHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(inputHandler, outputHandler);
        studyCafePassMachine.run();
    }

}
