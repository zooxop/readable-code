package cleancode.studycafe.mine.io;

import cleancode.studycafe.mine.model.pass.StudyCafePass;
import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;
import cleancode.studycafe.mine.model.pass.type.StudyCafePassTypeFinder;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public StudyCafePassType getPassTypeSelectingUserAction() {
        String userInput = SCANNER.nextLine();
        return StudyCafePassTypeFinder.findPassType(userInput);
    }

    @Override
    public StudyCafePass getSelectPass(List<StudyCafePass> passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        return passes.get(selectedIndex);
    }

    @Override
    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return "1".equals(userInput);
    }

}
