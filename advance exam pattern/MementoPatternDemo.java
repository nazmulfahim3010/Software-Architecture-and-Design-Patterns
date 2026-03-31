import java.util.ArrayList;
import java.util.List;

public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("this is state #1");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("this is state #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("this is state #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("this is state #4");
        System.out.println("current state: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("Current State: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("First saved State: " + originator.getState());

    }

}

class CareTaker {
    private List<Memento> Mementolist = new ArrayList<Memento>();

    public void add(Memento state) {
        Mementolist.add(state);
    }

    public Memento get(int index) {
        return Mementolist.get(index);
    }

}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getString() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento) {
        state = Memento.getState();
    }

}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}