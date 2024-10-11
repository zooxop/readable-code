package cleancode.studycafe.mine.studycafe.io;

import cleancode.studycafe.mine.studycafe.model.pass.StudyCafeLockerPass;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePass;

import java.util.List;

public interface FileHandler {
    List<StudyCafePass> readStudyCafePasses();

    List<StudyCafeLockerPass> readLockerPasses();
}
