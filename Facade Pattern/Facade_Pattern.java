public class Facade_Pattern {
    public static void main(String[] args) {
        ShapeMaker S = new ShapeMaker();

        S.drawCricle();
        S.drawRectangle();
        S.drawTriangle();
    }
}

interface Shape {
    void Draw();
}

class Circle implements Shape {
    @Override
    public void Draw() {
        System.out.println("This is circle ");
    }
}

class Rectangle implements Shape {
    @Override
    public void Draw() {
        System.out.println("This is Square");
    }
}

class Triangle implements Shape {
    @Override
    public void Draw() {
        System.out.println("This is triangle");
    }
}

class ShapeMaker {
    private Shape circle;
    private Shape square;
    private Shape triangle;

    public ShapeMaker() {
        circle = new Circle();
        square = new Rectangle();
        triangle = new Triangle();

    }

    public void drawCricle() {
        circle.Draw();
    }

    public void drawRectangle() {
        square.Draw();
    }

    public void drawTriangle() {
        triangle.Draw();
    }

}
