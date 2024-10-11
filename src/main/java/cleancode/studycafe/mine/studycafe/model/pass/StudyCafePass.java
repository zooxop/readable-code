package cleancode.studycafe.mine.studycafe.model.pass;

import cleancode.studycafe.mine.studycafe.model.pass.type.StudyCafePassType;

public interface StudyCafePass {

    StudyCafePassType getPassType();

    int getDuration();

    int getPrice();

    double getDiscountRate();
}
