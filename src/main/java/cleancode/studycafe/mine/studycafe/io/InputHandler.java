package cleancode.studycafe.mine.studycafe.io;

import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePass;
import cleancode.studycafe.mine.studycafe.model.pass.type.StudyCafePassType;

import java.util.List;

public interface InputHandler {
    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(List<StudyCafePass> passes);

    boolean getLockerSelection();
}
