package polymorphismchallenge;

public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println("Car -> startEngine");
    }

    protected void runEngine() {
        System.out.println("Car -> runEngine");
    }

    public void drive() {
        System.out.printf("Car -> driving, class is %s%n", this.getClass().getSimpleName());
        runEngine();
    }
}
