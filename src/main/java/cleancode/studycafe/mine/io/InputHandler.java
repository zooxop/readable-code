package cleancode.studycafe.mine.io;

import cleancode.studycafe.mine.model.pass.StudyCafePass;
import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

import java.util.List;

public interface InputHandler {
    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(List<StudyCafePass> passes);

    boolean getLockerSelection();
}
