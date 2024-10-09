package cleancode.studycafe.mine.model.pass;

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

    @Override
    public String display() {
        return String.format("%s시간권 - %d원", studyCafePassState.getDuration(), studyCafePassState.getPrice());
    }
}
