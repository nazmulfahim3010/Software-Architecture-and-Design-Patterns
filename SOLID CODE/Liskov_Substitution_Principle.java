
public class Liskov_Substitution_Principle {
    interface vehical {
        public int speed();

    }

    public abstract class EngineVehical implements vehical

    {

        public void startEngine() {
            System.out.println("Engine started");
        }
    }

    class car extends EngineVehical {
        int spd;

        car(int spd) {
            this.spd = spd;
        }

        @Override
        public int speed() {
            return spd;
        }

        @Override
        public void startEngine() {
            System.out.println("CAR engine started");
        }

    }

    class Bicycle implements vehical {
        int spd;

        Bicycle(int spd) {
            this.spd = spd;
        }

        @Override
        public int speed() {
            return spd;
        }

        // @Override
        // public void startEngine() {
        // throw new RuntimeException("No engine");
        // }
    }

    public static void main(String[] args) {
        Liskov_Substitution_Principle t = new Liskov_Substitution_Principle();
        car c = t.new car(20);
        System.out.println(c.speed());
        c.startEngine();
    }
}
