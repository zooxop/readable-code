package cleancode.studycafe.mine.studycafe;

import cleancode.studycafe.mine.studycafe.exception.AppException;
import cleancode.studycafe.mine.studycafe.io.FileHandler;
import cleancode.studycafe.mine.studycafe.io.impl.StudyCafeIOHandler;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafeLockerPass;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafeLockerPasses;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePass;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePasses;
import cleancode.studycafe.mine.studycafe.model.pass.type.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final StudyCafeIOHandler studyCafeIOHandler;
    private final FileHandler fileHandler;

    public StudyCafePassMachine(StudyCafeIOHandler studyCafeIOHandler, FileHandler fileHandler) {
        this.studyCafeIOHandler = studyCafeIOHandler;
        this.fileHandler = fileHandler;
    }

    public void run() {
        studyCafeIOHandler.showWelcomeMessageAndAnnouncement();

        try {
            StudyCafePassType studyCafePassType = askPassTypeSelectionInputToUser();
            StudyCafePass selectedPass = getSelectedPassInputFromUser(studyCafePassType);
            StudyCafeLockerPass lockerPass = getSelectedLockerPassInputFromUser(selectedPass);

            studyCafeIOHandler.showPassOrderSummary(selectedPass, lockerPass);
        } catch (AppException e) {
            studyCafeIOHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            studyCafeIOHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePassType askPassTypeSelectionInputToUser() {
        return studyCafeIOHandler.askPassTypeSelecting();
    }

    private StudyCafePass getSelectedPassInputFromUser(StudyCafePassType studyCafePassType) {
        List<StudyCafePass> passes = getStudyCafePassesInputFromUser(studyCafePassType);
        return studyCafeIOHandler.askPassSelecting(passes);
    }

    private StudyCafeLockerPass getSelectedLockerPassInputFromUser(StudyCafePass selectedPass) {
        StudyCafeLockerPass lockerPass = findSelectedLockerPassFromFile(selectedPass);
        getLockerPassInputIfDataExist(lockerPass);

        return lockerPass;
    }

    private void getLockerPassInputIfDataExist(StudyCafeLockerPass lockerPass) {
        if (lockerPass.isDataExist()) {
            boolean isUse = studyCafeIOHandler.askUseLockerPass(lockerPass);
            if (isUse) {
                lockerPass.select();
            }
        }
    }

    private List<StudyCafePass> getStudyCafePassesInputFromUser(StudyCafePassType studyCafePassType) {
        StudyCafePasses studyCafePasses = StudyCafePasses.of(fileHandler.readStudyCafePasses());
        return studyCafePasses.filterBy(studyCafePassType);
    }

    private StudyCafeLockerPass findSelectedLockerPassFromFile(StudyCafePass selectedPass) {
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(fileHandler.readLockerPasses());
        return lockerPasses.findBy(selectedPass);
    }
}
