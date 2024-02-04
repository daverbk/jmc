public class AreaCalculator {
    
    public static void main(String[] args) {

        System.out.println(area(5d)); // 78.53975
        System.out.println(area(-1d)); // -1
        System.out.println(area(5.0d, 4.0d)); // 20
        System.out.println(area(-1.0d, 4.0d)); // -1
    }

    public static double area(double x, double y) {
        double rectangleArea = -1d;

        if (x >= 0 && y >= 0) {
            rectangleArea = x * y;
        }

        return rectangleArea;
    }

    public static double area(double radius) {
        double area = -1d;

        if (radius >= 0) {
            area = radius * (radius * Math.PI);
        }

        return area;
    }
}
