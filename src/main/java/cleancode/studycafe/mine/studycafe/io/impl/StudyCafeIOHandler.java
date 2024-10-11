package cleancode.studycafe.mine.studycafe.io.impl;

import cleancode.studycafe.mine.studycafe.io.InputHandler;
import cleancode.studycafe.mine.studycafe.io.OutputHandler;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafeLockerPass;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePass;
import cleancode.studycafe.mine.studycafe.model.pass.type.StudyCafePassType;

import java.util.List;

public class StudyCafeIOHandler {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private StudyCafeIOHandler(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public static StudyCafeIOHandler of(InputHandler inputHandler, OutputHandler outputHandler) {
        return new StudyCafeIOHandler(inputHandler, outputHandler);
    }

    public void showWelcomeMessageAndAnnouncement() {
        outputHandler.showWelcomeMessage();
        outputHandler.showAnnouncement();
    }

    public StudyCafePassType askPassTypeSelecting() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    public StudyCafePass askPassSelecting(List<StudyCafePass> passes) {
        outputHandler.showPassListForSelection(passes);
        return inputHandler.getSelectPass(passes);
    }

    public boolean askUseLockerPass(StudyCafeLockerPass lockerPass) {
        outputHandler.askLockerPass(lockerPass);
        return inputHandler.getLockerSelection();
    }

    public void showSimpleMessage(String message) {
        outputHandler.showSimpleMessage(message);
    }

    public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
        outputHandler.showPassOrderSummary(selectedPass, lockerPass);
    }
}
