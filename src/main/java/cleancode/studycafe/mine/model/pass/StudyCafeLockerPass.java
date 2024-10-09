package cleancode.studycafe.mine.model.pass;

import cleancode.studycafe.mine.model.pass.type.StudyCafePassType;

public class StudyCafeLockerPass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public String display() {
        return String.format("%s주권 - %d원", duration, price);  // FIXME: passType 따라 display 내용 바뀌도록 추상화 필요
    }

}
