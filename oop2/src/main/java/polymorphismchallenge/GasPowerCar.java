package polymorphismchallenge;

public class GasPowerCar extends Car {
    private double avgKmPerLitre;
    private int cylinders;

    public GasPowerCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf("%d cylinders are roaring%n", cylinders);
    }

    @Override
    protected void runEngine() {
        super.runEngine();
        System.out.printf("%d cylinders are starting rotation%n", cylinders);
    }
}
