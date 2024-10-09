package cleancode.studycafe.mine.io.parse;

import cleancode.studycafe.mine.model.pass.StudyCafePass;
import cleancode.studycafe.mine.model.pass.StudyCafePassFactory;
import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

public class StudyCafePassParser implements FileParser<StudyCafePass> {
    @Override
    public StudyCafePass parse(String[] values) {
        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
        int duration = Integer.parseInt(values[1]);
        int price = Integer.parseInt(values[2]);
        double discountRate = Double.parseDouble(values[3]);

        return StudyCafePassFactory.createStudyCafePass(studyCafePassType, duration, price, discountRate);
    }
}