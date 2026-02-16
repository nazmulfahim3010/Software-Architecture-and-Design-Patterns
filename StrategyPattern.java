public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(5, 4));
    }

}

interface IStrategy {
    int doOperation(int a, int b);
}

class OperationAdd implements IStrategy {
    @Override
    public int doOperation(int a, int b) {
        return a + b;
    }
}

class OperationSubstruct implements IStrategy {
    @Override
    public int doOperation(int a, int b) {
        return a - b;
    }
}

class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}