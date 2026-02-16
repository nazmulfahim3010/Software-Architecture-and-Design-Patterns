import java.util.ArrayList;
import java.util.List;

public class RestaurantPattern {
    public static void main(String[] args) {
        Chef chef = new Chef();

        Command burgerCommand = new BurgerCommand(chef);
        Command pizzaCommand = new PizzaCommand(chef);

        Waiter waiter = new Waiter();
        waiter.takeOrder(pizzaCommand);
        waiter.takeOrder(burgerCommand);

        waiter.submitOrder();

    }

}

class Chef {
    public void makeBurger() {
        System.out.println("chef is making a burger");
    }

    public void makePizza() {
        System.out.print("Chef is making a pizza");
    }
}

interface Command {
    void execute();
}

class BurgerCommand implements Command {
    private Chef chef;

    public BurgerCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.makeBurger();
    }
}

class PizzaCommand implements Command {
    private Chef chef;

    public PizzaCommand(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.makePizza();
    }
}

class Waiter {
    private List<Command> orders = new ArrayList<>();

    public void takeOrder(Command command) {
        orders.add(command);
    }

    public void submitOrder() {
        for (Command command : orders) {
            command.execute();
        }
        orders.clear();
    }
}