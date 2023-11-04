package polymorphismchallenge;

public class Car {
    private String description;

    public Car() {
    }

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        runEngine();
    }

    public void drive() {
        System.out.println("Driving a car ...");
    }

    protected void runEngine() {
        System.out.printf("Starting the %s's engine ...%n", this.getClass().getSimpleName());
    }
}
