package codesquad.week2.Mission2._1;

public class Car {
    private static int number = 1000;
    private final int carNumber;


    public Car() {
        carNumber = number++;
    }

    public String showCarNumber() {
        return String.valueOf(carNumber);
    }


}
