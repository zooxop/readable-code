package cleancode.studycafe.mine.studycafe.model.pass.impl;

import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePass;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePassState;
import cleancode.studycafe.mine.studycafe.model.pass.type.StudyCafePassType;

public class StudyCafePassHourly implements StudyCafePass {
    StudyCafePassState studyCafePassState;

    private StudyCafePassHourly(StudyCafePassState studyCafePassState) {
        this.studyCafePassState = studyCafePassState;
    }

    public static StudyCafePass of(StudyCafePassState studyCafePassState) {
        return new StudyCafePassHourly(studyCafePassState);
    }

    @Override
    public StudyCafePassType getPassType() {
        return StudyCafePassType.HOURLY;
    }

    @Override
    public int getDuration() {
        return studyCafePassState.getDuration();
    }

    @Override
    public int getPrice() {
        return studyCafePassState.getPrice();
    }

    @Override
    public double getDiscountRate() {
        return studyCafePassState.getDiscountRate();
    }
}
