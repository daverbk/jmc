package interfaces;

public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flightEnabled = bird;
        Trackable trackable = bird;

        /*animal.move();

        flightEnabled.takeOff();
        flightEnabled.fly();
        flightEnabled.land();

        trackable.track();
        flightEnabled.land();*/

        inFlight(flightEnabled);
        inFlight(new Jet());
        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = FlightEnabled.KM_TO_MILES * kmsTraveled;
        System.out.println("The truck traveled " + milesTraveled + " miles");
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable trackable) {
            trackable.track();
        }
        flier.land();
    }
}
