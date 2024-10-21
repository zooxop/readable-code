package cleancode.studycafe.mine.studycafe.model.pass.impl;

import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePass;
import cleancode.studycafe.mine.studycafe.model.pass.StudyCafePassState;
import cleancode.studycafe.mine.studycafe.model.pass.type.StudyCafePassType;

public class StudyCafePassFixed implements StudyCafePass {
    private final StudyCafePassState studyCafePassState;

    private StudyCafePassFixed(StudyCafePassState studyCafePassState) {
        this.studyCafePassState = studyCafePassState;
    }

    public static StudyCafePass of(StudyCafePassState studyCafePassState) {
        return new StudyCafePassFixed(studyCafePassState);
    }

    @Override
    public StudyCafePassType getPassType() {
        return StudyCafePassType.FIXED;
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

    public String display() {
        return String.format("%s주권 - %d원", studyCafePassState.getDuration(), studyCafePassState.getPrice());
    }
}