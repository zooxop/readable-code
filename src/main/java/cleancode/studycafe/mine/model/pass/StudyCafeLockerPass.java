package cleancode.studycafe.mine.model.pass;

import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

public class StudyCafeLockerPass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private boolean isSelected;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price, boolean isSelected) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.isSelected = isSelected;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price, false);
    }

    public static StudyCafeLockerPass ofNone() {
        return new StudyCafeLockerPass(StudyCafePassType.NONE, 0, 0, false);
    }

    public void select() {
        isSelected = true;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int getPriceOnlySelected() {
        return isSelected ? price : 0;
    }

    public boolean isDataExist() {
        return passType != StudyCafePassType.NONE;
    }

    public boolean isSameTypeAndDuration(StudyCafePassType passType, int duration) {
        return this.passType == passType && this.duration == duration;
    }

    public String display() {
        return String.format("%s주권 - %d원", duration, price);  // FIXME: passType 따라 display 내용 바뀌도록 추상화 필요
    }
}
