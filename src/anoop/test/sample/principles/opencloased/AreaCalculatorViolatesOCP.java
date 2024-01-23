package anoop.test.sample.principles.opencloased;

// This class calculate area of different shapes.
// This violates the OCP - When new shape comes we need to modify this class.

public class AreaCalculatorViolatesOCP {
    public double calculateRectangleAre(RectangleViolatesOCP rectangle) {
        return rectangle.length * rectangle.width;
    }
    public double calculateRectangleAre(CircleViolatesOCP circle) {
        return (22/7) * circle.radius * circle.radius;
    }
}

class CircleViolatesOCP {
    public double radius;
}

class RectangleViolatesOCP {
    public double length;
    public double width;
}