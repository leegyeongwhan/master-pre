package codesquad.week2.Mission2._3;

public class Memento {
    private Gamer gamer;

    private Memento(Gamer gamer) {
        this.gamer = gamer;
    }

    public static Memento getMemento(Gamer gamer) {
        return new Memento(gamer);
    }

    public Gamer getState() {
        return gamer;
    }

    public void setState(Memento memento) {
        this.gamer = gamer;
    }
}
