package interfaces;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        inFlight(new Jet());

//        OrbitEarth.log("Testing " + new Satellite());

        orbit(new Satellite());
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable trackable) {
            trackable.track();
        }
        flier.land();
    }

    private static void orbit(OrbitEarth flier) {
        flier.takeOff();
        flier.fly();
        flier.land();
    }

    private static void triggerFliers(List<FlightEnabled> fliers) {

        for (FlightEnabled flier : fliers) {
            flier.takeOff();
        }
    }

    private static void flyFliers(List<FlightEnabled> fliers) {

        for (FlightEnabled flier : fliers) {
            flier.fly();
        }
    }

    private static void landFliers(List<FlightEnabled> fliers) {

        for (FlightEnabled flier : fliers) {
            flier.land();
        }
    }
}
