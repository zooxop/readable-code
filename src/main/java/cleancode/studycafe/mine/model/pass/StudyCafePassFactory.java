package cleancode.studycafe.mine.model.pass;

import cleancode.studycafe.mine.model.pass.impl.StudyCafePassFixed;
import cleancode.studycafe.mine.model.pass.impl.StudyCafePassHourly;
import cleancode.studycafe.mine.model.pass.impl.StudyCafePassWeekly;
import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

public class StudyCafePassFactory {
    private StudyCafePassFactory() {

    }

    public static StudyCafePass createStudyCafePass(StudyCafePassType studyCafePassType, int duration, int price, double discountRate) {
        StudyCafePassState state = StudyCafePassState.of(duration, price, discountRate);

        return switch (studyCafePassType) {
            case HOURLY -> StudyCafePassHourly.of(state);
            case WEEKLY -> StudyCafePassWeekly.of(state);
            case FIXED -> StudyCafePassFixed.of(state);
            default -> throw new IllegalStateException("잘못된 StudyCafePassType: " + studyCafePassType);
        };
    }
}
