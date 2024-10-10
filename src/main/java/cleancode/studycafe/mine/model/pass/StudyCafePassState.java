package cleancode.studycafe.mine.model.pass;

public class StudyCafePassState {
    private int duration;
    private int price;
    private double discountRate;

    private StudyCafePassState(int duration, int price, double discountRate) {
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafePassState of(int duration, int price, double discountRate) {
        return new StudyCafePassState(duration, price, discountRate);
    }

    public void updateProperties(int duration, int price, double discountRate) {
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
