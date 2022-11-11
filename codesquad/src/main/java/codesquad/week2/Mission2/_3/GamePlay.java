package codesquad.week2.Mission2._3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args) {

        Game game = new Game();
        List<String> list = new ArrayList<>(Arrays.asList("사과", "샤인머스킷", "귤"));
        Gamer gammer1 = game.getGammer(1000, list);
        Gamer gammer2 = game.getGammer(1000, list);
        Originator originator = new Originator(gammer1);
        Memento memento = Memento.getMemento(gammer2); //객체 동일성보장

        int money = gammer1.getMoney();
        List<String> fruits = gammer1.getFruits();
        int inx = 0;

        while (inx < 101 && money > 0) {
            Dice dice = game.getDice();
            int[] gameDice = dice.getDice();

            if (money > memento.getState().getMoney()) {
                Memento createMemento = originator.createMemento();
                memento = createMemento;
            } else if (money < memento.getState().getMoney() / 2) {
                Originator newOriginator = originator.restoreMemento(memento.getState());
                originator = newOriginator;
                money = originator.getState().getMoney();
            }
            money = diceValid(money, fruits, gameDice);
            originator = new Originator(new Gamer(money, list));
            print(originator, dice);
            inx++;
        }
        return;
    }

    private static int diceValid(int money, List<String> fruits, int[] gameDice) {
        if (gameDice[0] == 1 || gameDice[0] == 3) {
            money += 100;
        } else if (gameDice[0] == 2 || gameDice[0] == 4) {
            money /= 2;
        } else if (gameDice[0] == 6 || gameDice[0] == 6) {
            Scanner scanner = new Scanner(System.in);
            fruits.add(scanner.next());
        }
        return money;
    }

    private static void print(Originator originator, Dice dice) {
        System.out.println(Arrays.toString(dice.getDice()));
        System.out.println(originator.getState().getMoney());
        System.out.println(originator.getState().getFruits());
    }
}
