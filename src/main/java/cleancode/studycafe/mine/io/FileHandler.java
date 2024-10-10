package cleancode.studycafe.mine.io;

import cleancode.studycafe.mine.model.pass.StudyCafeLockerPass;
import cleancode.studycafe.mine.model.pass.StudyCafePass;

import java.util.List;

public interface FileHandler {
    List<StudyCafePass> readStudyCafePasses();

    List<StudyCafeLockerPass> readLockerPasses();
}
