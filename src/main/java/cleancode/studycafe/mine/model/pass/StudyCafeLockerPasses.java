package cleancode.studycafe.mine.model.pass;

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

    public StudyCafeLockerPass findBySelectedPass(StudyCafePass selectedPass) {
        List<StudyCafeLockerPass> passes = new ArrayList<>(lockerPasses);

        return passes.stream()
            .filter(option ->
                option.isSameType(selectedPass.getPassType())
                    && option.isSameDuration(selectedPass.getDuration())
            )
            .findFirst()
            .orElseGet(StudyCafeLockerPass::ofNone);
    }
}
