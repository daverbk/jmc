package polymorphismchallenge;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("2022 Blue Ferrari 296 GTS");
        runRace(car);

        Car car2 = new GasPowerCar("2022 Blue Ferrari 296 GTS", 15.4, 6);
        runRace(car2);

        Car car3 = new ElectricCar("2022 Red Tesla Model 3", 568, 75);
        runRace(car3);

        Car car4 = new HybridCar("2022 Black Ferrari SF90 Stradale", 16, 8, 8);
        runRace(car4);

        if (car4 instanceof HybridCar hybrid) {
            hybrid.useStoredEnergy();
        }
    }

    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
