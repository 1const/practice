package functions.test;

public class MyPoint {
    public double x;
    public double y;
    public double z;

    public MyPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static double depth(double o) {
        double kX = o * 0.5;
        return o + Math.abs(kX);
    }
}
