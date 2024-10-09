package cleancode.studycafe.mine;

import cleancode.studycafe.mine.exception.AppException;
import cleancode.studycafe.mine.io.*;
import cleancode.studycafe.mine.model.pass.StudyCafeLockerPass;
import cleancode.studycafe.mine.model.pass.StudyCafePass;
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
        showWelcomeMessageToUser();

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

    private void showWelcomeMessageToUser() {
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
        if (selectedPass.getPassType() != StudyCafePassType.FIXED) {
            return null;
        }
        StudyCafeLockerPass lockerPass = findSelectedLockerPassFromFile(selectedPass);
        outputHandler.askLockerPass(lockerPass);

        if (!inputHandler.getLockerSelection()) {
            return null;
        }
        return lockerPass;
    }

    private StudyCafeLockerPass findSelectedLockerPassFromFile(StudyCafePass selectedPass) {
        List<StudyCafeLockerPass> lockerPasses = fileHandler.readLockerPasses();
        return lockerPasses.stream()
            .filter(option ->
                option.getPassType() == selectedPass.getPassType()
                    && option.getDuration() == selectedPass.getDuration()
            )
            .findFirst()
            .orElseThrow(() -> new AppException("Locker 정보를 가져올 수 없습니다."));
    }

    private List<StudyCafePass> getStudyCafePassesInputFromUser(StudyCafePassType studyCafePassType) {
        List<StudyCafePass> studyCafePasses = fileHandler.readStudyCafePasses();
        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
            .toList();
    }
}
