package genericclasschallenge;

public class Point implements Mappable {
    private final double latitude;
    private final double longitude;
    private final String name;

    public Point(String name, double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    @Override
    public void render() {
        System.out.println("Render " + name + " as POINT ([" + latitude + ", " + longitude + "])");
    }
}
