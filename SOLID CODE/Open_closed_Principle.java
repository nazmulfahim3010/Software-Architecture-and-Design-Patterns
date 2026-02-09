
interface AreaCalculator {
    double area();
}

class Rectangle implements AreaCalculator {
    double height;
    double width;

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return height * width;
    }
}

class Circle implements AreaCalculator {
    double redius;

    Circle(double redius) {
        this.redius = redius;
    }

    @Override
    public double area() {
        return 3.1416 * redius;
    }
}

public class Open_closed_Principle {
    public static void main(String[] args) {
        // Test1 t = new Test1();
        Rectangle sqr = new Rectangle(10.00, 12.25);
        System.out.println(sqr.area());

    }
}
