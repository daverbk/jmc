package genericclasschallenge;

import java.util.Arrays;

abstract public class Line implements Mappable {
    private final double[][] locations;

    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for (String location : locations) {
            this.locations[index++] = Mappable.stringToLatLon(location);
        }
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }

    private String locations() {
        return Arrays.deepToString(locations);
    }
}
