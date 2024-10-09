package cleancode.studycafe.mine.model.pass;

public interface StudyCafePass {
    //StudyCafePass of(StudyCafePassState studyCafePassState);

    StudyCafePassType getPassType();

    int getDuration();

    int getPrice();

    double getDiscountRate();

    String display();
}
