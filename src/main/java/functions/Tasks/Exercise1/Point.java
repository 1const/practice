package functions.Tasks.Exercise1;

public class Point {
    public final double x;
    public final double y;
    public final double z;

    public static void main(String[] args) {
        Point firstPoint = new Point(2.3, 5.4, 2.5);
        Point secondPoint = new Point(2.1, 4.3, 8.7);
        System.out.println("Точка с координатами: " + "x-" + firstPoint.x + ", y-" + firstPoint.y + ", z-" + firstPoint.z);
        System.out.println("Точка с координатами: " + "x-" + secondPoint.x + ", y-" + secondPoint.y + ", z-" + secondPoint.z);
    }

    public Point(double givenX, double givenY, double givenZ) {
        x = givenX;
        y = givenY;
        z = givenZ;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }
}
