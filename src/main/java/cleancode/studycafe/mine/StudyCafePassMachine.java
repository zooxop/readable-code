package cleancode.studycafe.mine;

import cleancode.studycafe.mine.exception.AppException;
import cleancode.studycafe.mine.io.*;
import cleancode.studycafe.mine.model.pass.StudyCafeLockerPass;
import cleancode.studycafe.mine.model.pass.StudyCafeLockerPasses;
import cleancode.studycafe.mine.model.pass.StudyCafePass;
import cleancode.studycafe.mine.model.pass.StudyCafePasses;
import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final FileHandler fileHandler;

    public StudyCafePassMachine(InputHandler inputHandler, OutputHandler outputHandler, FileHandler fileHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.fileHandler = fileHandler;
    }

    public void run() {
        showWelcomeMessageAndAnnouncementToUser();

        try {
            StudyCafePassType studyCafePassType = askPassTypeSelectionInputToUser();
            StudyCafePass selectedPass = getSelectedPassInputFromUser(studyCafePassType);
            StudyCafeLockerPass lockerPass = getSelectedLockerPassInputFromUser(selectedPass);

            outputHandler.showPassOrderSummary(selectedPass, lockerPass);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private void showWelcomeMessageAndAnnouncementToUser() {
        outputHandler.showWelcomeMessage();
        outputHandler.showAnnouncement();
    }

    private StudyCafePassType askPassTypeSelectionInputToUser() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    private StudyCafePass getSelectedPassInputFromUser(StudyCafePassType studyCafePassType) {
        List<StudyCafePass> passes = getStudyCafePassesInputFromUser(studyCafePassType);
        outputHandler.showPassListForSelection(passes);
        return inputHandler.getSelectPass(passes);
    }

    private StudyCafeLockerPass getSelectedLockerPassInputFromUser(StudyCafePass selectedPass) {
        StudyCafeLockerPass lockerPass = findSelectedLockerPassFromFile(selectedPass);
        getLockerPassInputIfDataExist(lockerPass);

        return lockerPass;
    }

    private void getLockerPassInputIfDataExist(StudyCafeLockerPass lockerPass) {
        if (lockerPass.isDataExist()) {
            outputHandler.askLockerPass(lockerPass);

            if (inputHandler.getLockerSelection()) {
                lockerPass.select();
            }
        }
    }

    private List<StudyCafePass> getStudyCafePassesInputFromUser(StudyCafePassType studyCafePassType) {
        StudyCafePasses studyCafePasses = StudyCafePasses.of(fileHandler.readStudyCafePasses());
        return studyCafePasses.filterByPassType(studyCafePassType);
    }

    private StudyCafeLockerPass findSelectedLockerPassFromFile(StudyCafePass selectedPass) {
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(fileHandler.readLockerPasses());
        return lockerPasses.findBySelectedPass(selectedPass);
    }
}
