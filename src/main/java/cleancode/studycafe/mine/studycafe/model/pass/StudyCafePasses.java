package cleancode.studycafe.mine.studycafe.model.pass;

import cleancode.studycafe.mine.studycafe.model.pass.type.StudyCafePassType;

import java.util.ArrayList;
import java.util.List;

public class StudyCafePasses {
    private final List<StudyCafePass> passes;

    private StudyCafePasses(List<StudyCafePass> passes) {
        this.passes = new ArrayList<>(passes);
    }

    public static StudyCafePasses of(List<StudyCafePass> passes) {
        return new StudyCafePasses(passes);
    }

    public List<StudyCafePass> filterBy(StudyCafePassType studyCafePassType) {
        List<StudyCafePass> studyCafePasses = new ArrayList<>(passes);

        return studyCafePasses.stream()
            .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
            .toList();
    }
}
