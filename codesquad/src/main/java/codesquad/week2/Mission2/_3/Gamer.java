package codesquad.week2.Mission2._3;

import java.util.List;

public class Gamer {
    private int money;
    private List<String> fruits;

    public Gamer(int money, List<String> fruits) {
        this.money = money;
        this.fruits = fruits;
    }

    public int getMoney() {
        return money;
    }

    public List<String> getFruits() {
        return fruits;
    }
}
