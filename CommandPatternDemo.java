import java.util.ArrayList;
import java.util.List;

public class CommandPatternDemo {
    public static void main(String[] args) {

        // Receiver
        Chef chef = new Chef();

        // Concrete Commands
        Command burgerCommand = new BurgerCommand(chef);
        Command pizzaCommand = new PizzaCommand(chef);

        // Invoker
        Waiter waiter = new Waiter();

        // Taking orders
        waiter.takeOrder(burgerCommand);
        waiter.takeOrder(pizzaCommand);

        // Executing orders
        waiter.submitOrders();
    }
}

interface Command {
    void execute();
}

class Chef {
    public void makeBurger() {
        System.out.println("Chef is making a burger.");
    }

    public void makePizza() {
        System.out.println("Chef is making a pizza.");
    }
}

class BurgerCommand implements Command {
    private final Chef chef;

    public BurgerCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.makeBurger();
    }
}

class PizzaCommand implements Command {
    private final Chef chef;

    public PizzaCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.makePizza();
    }
}

class Waiter {
    private final List<Command> orders = new ArrayList<>();

    public void takeOrder(Command command) {
        orders.add(command);
    }

    public void submitOrders() {
        for (Command command : orders) {
            command.execute();
        }
        orders.clear();
    }
}
