package anoop.test.sample.principles.liskovsubstitution;

abstract class Vehicle {
    abstract int getSpeed();
    abstract int getCapacity();
}

class Car extends Vehicle {

    @Override
    int getSpeed() {
        return 0;
    }

    @Override
    int getCapacity() {
        return 0;
    }

    String getModel() {
        return "Benz";
    }
}

class Bus extends Vehicle {

    @Override
    int getSpeed() {
        return 0;
    }

    @Override
    int getCapacity() {
        return 0;
    }

    String getEngine() {
        return "K10-xx";
    }
}

public class Example {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.getSpeed();
        vehicle = new Bus(); // Substituted by another sub class
        vehicle.getCapacity();
    }
}
