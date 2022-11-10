package codesquad.week2.Mission2._1;

public class HyundaiFactory {

    private HyundaiFactory() {
    }

    public static HyundaiFactory getFactory() {
        return new HyundaiFactory();
    }

    public Car createCar() {
        return new Car();
    }
}
