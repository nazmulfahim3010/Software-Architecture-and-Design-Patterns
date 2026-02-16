public class Factory_Pattern {
    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        Pizza pizza = simplePizzaFactory.createPizza("cheese");
        pizza.prepare();
        simplePizzaFactory.createPizza("veggie").prepare();
        ;
    }

}

interface Pizza {
    void prepare();
}

class cheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Cheese Pizza Prepared");
    }
}

class pepparoniPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Pepparoni Pizza Prepared");
    }
}

class VeggiePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Veggie Pizza Prepared");
    }
}

class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new cheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new pepparoniPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}