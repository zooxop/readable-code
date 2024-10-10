package cleancode.studycafe.mine.model.pass;

import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

public interface StudyCafePass {

    StudyCafePassType getPassType();

    int getDuration();

    int getPrice();

    double getDiscountRate();

    String display();
}
