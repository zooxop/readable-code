package cleancode.studycafe.mine.studycafe.model.pass;

import java.util.ArrayList;
import java.util.List;

public class StudyCafeLockerPasses {
    private final List<StudyCafeLockerPass> lockerPasses;

    private StudyCafeLockerPasses(List<StudyCafeLockerPass> lockerPasses) {
        this.lockerPasses = lockerPasses;
    }

    public static StudyCafeLockerPasses of(List<StudyCafeLockerPass> lockerPasses) {
        return new StudyCafeLockerPasses(lockerPasses);
    }

    public StudyCafeLockerPass findBy(StudyCafePass pass) {
        List<StudyCafeLockerPass> passes = new ArrayList<>(lockerPasses);

        return passes.stream()
            .filter(lockerPass -> lockerPass.isSameTypeAndDuration(pass.getPassType(), pass.getDuration()))
            .findFirst()
            .orElseGet(StudyCafeLockerPass::ofNone);
    }
}
