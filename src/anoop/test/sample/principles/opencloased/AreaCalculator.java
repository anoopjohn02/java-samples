package anoop.test.sample.principles.opencloased;

interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    public double radius;

    @Override
    public double calculateArea() {
        return (22/7) * radius * radius;
    }
}

class Rectangle implements Shape {
    public double length;
    public double width;

    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea(); // Delegation Principle
    }
}

