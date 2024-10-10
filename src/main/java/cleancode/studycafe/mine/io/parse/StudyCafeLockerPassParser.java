package cleancode.studycafe.mine.io.parse;

import cleancode.studycafe.mine.model.pass.StudyCafeLockerPass;
import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

public class StudyCafeLockerPassParser implements FileParser<StudyCafeLockerPass> {
    @Override
    public StudyCafeLockerPass parse(String[] values) {
        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);

        return StudyCafeLockerPass.of(studyCafePassType, duration, price);
    }
}
