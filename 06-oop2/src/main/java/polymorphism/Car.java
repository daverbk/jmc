package polymorphism;

public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        engine = true;
        wheels = 4;
    }

    public String  startEngine() {
        return String.format("The %s engine is starting%n", this.getClass().getSimpleName());
    }

    public String accelerate() {
        return String.format("The %s car is accelerating%n", this.getClass().getSimpleName());
    }

    public String brake() {
        return String.format("The %s car is braking%n", this.getClass().getSimpleName());
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}
