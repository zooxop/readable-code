package cleancode.studycafe.mine.model.pass;

import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

public interface StudyCafePass {
    //StudyCafePass of(StudyCafePassState studyCafePassState);

    StudyCafePassType getPassType();

    int getDuration();

    int getPrice();

    double getDiscountRate();

    String display();
}
