package codesquad.week2.Mission2._3;

public class Originator {
    private Gamer state;

    public Originator(Gamer m) {
        this.state = m;
    }

    public Originator restoreMemento(Gamer state) {
        return new Originator(state);
    }

    public void setMemento(Memento memento) {
        state = memento.getState();
    }

    public Memento createMemento() {
        return Memento.getMemento(state);
    }

    public Gamer getState() {
        return state;
    }

}
