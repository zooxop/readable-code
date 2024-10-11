package cleancode.studycafe.mine;

import cleancode.studycafe.mine.studycafe.StudyCafePassMachine;
import cleancode.studycafe.mine.studycafe.io.FileHandler;
import cleancode.studycafe.mine.studycafe.io.InputHandler;
import cleancode.studycafe.mine.studycafe.io.OutputHandler;
import cleancode.studycafe.mine.studycafe.io.impl.ConsoleInputHandler;
import cleancode.studycafe.mine.studycafe.io.impl.ConsoleOutputHandler;
import cleancode.studycafe.mine.studycafe.io.impl.StudyCafeFileHandler;
import cleancode.studycafe.mine.studycafe.io.impl.StudyCafeIOHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        StudyCafeIOHandler studyCafeIOHandler = StudyCafeIOHandler.of(inputHandler, outputHandler);

        FileHandler fileHandler = new StudyCafeFileHandler();

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeIOHandler, fileHandler);
        studyCafePassMachine.run();
    }

}
