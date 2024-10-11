package cleancode.studycafe.mine.studycafe.parse.impl;

import cleancode.studycafe.mine.studycafe.model.pass.StudyCafeLockerPass;
import cleancode.studycafe.mine.studycafe.model.pass.type.StudyCafePassType;
import cleancode.studycafe.mine.studycafe.parse.FileParser;

public class StudyCafeLockerPassParser implements FileParser<StudyCafeLockerPass> {
    @Override
    public StudyCafeLockerPass parse(String[] values) {
        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);

        return StudyCafeLockerPass.of(studyCafePassType, duration, price);
    }
}
