package cleancode.studycafe.mine;

import cleancode.studycafe.mine.io.*;

public class StudyCafeApplication {

    public static void main(String[] args) {
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        FileHandler fileHandler = new StudyCafeFileHandler();

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(inputHandler, outputHandler, fileHandler);
        studyCafePassMachine.run();
    }

}
