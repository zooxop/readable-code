package cleancode.studycafe.mine.studycafe.io;

import cleancode.studycafe.mine.studycafe.model.pass.StudyCafeLockerPass;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePass;

import java.util.List;

public interface OutputHandler {
    void showWelcomeMessage();

    void showAnnouncement();

    void askPassTypeSelection();

    void showPassListForSelection(List<StudyCafePass> passes);

    void askLockerPass(StudyCafeLockerPass lockerPass);

    void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass);

    void showSimpleMessage(String message);
}
