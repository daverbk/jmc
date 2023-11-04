package polymorphismchallenge;

public class ElectricCar extends Car {
    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf("The next charge is expected in %.2fkm%n", avgKmPerCharge);
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.printf("Engine of an %s is started%n", this.getClass().getSimpleName());
    }
}
