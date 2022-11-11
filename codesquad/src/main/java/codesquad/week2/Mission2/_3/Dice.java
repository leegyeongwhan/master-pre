package codesquad.week2.Mission2._3;

import java.util.Random;

public class Dice {
    private int[] dice;

    private int[] randomDice() {
        int[] dice = new int[2];
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int randomNum = random.nextInt(6) + 1;
            dice[i] = randomNum;
        }
        return dice;
    }

    public int[] getDice() {
        return dice;
    }

    public Dice() {
        this.dice = randomDice();
    }
}
