package genericclasschallenge;

import java.util.Arrays;

public class Line implements Mappable {
    private final double[][] coordinates;
    private final String name;

    public Line(String name, double[][] coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void render() {
        System.out.println("Render " +  name + " as LINE (" + Arrays.deepToString(coordinates) + ")");
    }
}
