package linkedlistchallenge;

public class Destination {
    private String town;
    private double distanceFromStart;

    public Destination(String town, double distanceFromStart) {
        this.town = town;
        this.distanceFromStart = distanceFromStart;
    }

    public String getTown() {
        return town;
    }

    public double getDistanceFromStart() {
        return distanceFromStart;
    }
}
