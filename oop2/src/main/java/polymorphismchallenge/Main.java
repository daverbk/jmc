package polymorphismchallenge;

public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        car.startEngine();
        car.drive();

        Car car1 = new ElectricCar("Electric car", 300, 50);
        car1.startEngine();
        car1.drive();

        Car car2 = new GasPowerCar("Gas power car", 300, 4);
        car2.startEngine();
        car2.drive();

        Car car3 = new HybridCar("Hybrid car", 300, 4, 40);
        car3.startEngine();
        car3.drive();

        if (car3 instanceof HybridCar hybrid) {
            hybrid.useStoredEnergy();
        }
    }
}
