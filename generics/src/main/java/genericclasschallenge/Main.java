package genericclasschallenge;

public class Main {
    public static void main(String[] args) {
        var tatra = new NationalPark("Tatra National Park",
                49.27354993349509,
                19.981446212229784);

        var wisla = new River("Wisla River", new double[][]{
                {50.051601820951866, 20.04747803618233},
                {49.98897834152374, 19.580707826219463},
                {50.030394443070016, 19.143627257457876}
        });

        Layer<Point> pointsLayer = new Layer<>(tatra);
        Layer<Line> linesLayer = new Layer<>(wisla);

        pointsLayer.render();
        linesLayer.render();
    }
}
