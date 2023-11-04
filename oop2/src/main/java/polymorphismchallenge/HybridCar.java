package polymorphismchallenge;

public class HybridCar extends Car {
    private double avgKmPerLitre;
    private int cylinders;
    private int batterySize;

    public HybridCar() {
    }

    public HybridCar(String description, double avgKmPerLitre, int cylinders, int batterySize) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
        this.batterySize = batterySize;
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Storing power when accelerating");
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.println("Starting using gas");
    }

    public void useStoredEnergy() {
        System.out.println("Stored energy is used");
    }
}
