package cleancode.studycafe.mine.model.pass;

import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

public class StudyCafePassWeekly implements StudyCafePass {
    StudyCafePassState studyCafePassState;

    private StudyCafePassWeekly(StudyCafePassState studyCafePassState) {
        this.studyCafePassState = studyCafePassState;
    }

    public static StudyCafePass of(StudyCafePassState studyCafePassState) {
        return new StudyCafePassWeekly(studyCafePassState);
    }

    @Override
    public StudyCafePassType getPassType() {
        return StudyCafePassType.WEEKLY;
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

    @Override
    public String display() {
        return String.format("%s주권 - %d원", studyCafePassState.getDuration(), studyCafePassState.getPrice());
    }
}
