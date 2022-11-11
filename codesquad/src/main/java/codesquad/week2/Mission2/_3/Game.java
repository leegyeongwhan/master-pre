package codesquad.week2.Mission2._3;

import java.util.List;

public class Game {

    public Dice getDice() {
        return new Dice();
    }

    public Gamer getGammer(int money, List<String> fruits)
    {
        return new Gamer(money, fruits);
    }
}
