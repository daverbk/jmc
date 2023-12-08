package interfaces;

import java.util.Date;

public interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();

    private static void log(String description) {
        var today = new Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {

        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages next = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transition to " + next);
        return next;
    }
}
