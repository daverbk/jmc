package polymorphismchallenge;

public class GasPowerCar extends Car {
    private double avgKmPerLitre;
    private int cylinders = 6;

    public GasPowerCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("Gas -> All %d cylinders are fired up, Ready!%n", cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("Gas -> usage exceeds average: %.2f %n", avgKmPerLitre);
    }
}
