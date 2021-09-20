package functions.shape;
abstract class shape {
    public static final double pi = 3.14;
    private double volume;
    shape(double volume){
        this.volume = volume;
    }
    public double getVolume() {
        return volume;
    }
}
class Pyramid  extends shape{
    private  double square;
    private  double height;
    Pyramid(double square, double height) {
        super( square*height/3);
        this.height = height;
        this.square = square;
    }
    public double getSquare() {
        return square;
    }
    public double getHeight() {
        return height;
    }
}
abstract class SolidOfRevolution extends shape{
    private double radius;
    SolidOfRevolution(double volume, double radius){
        super(volume);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
}
class Cylinder extends  SolidOfRevolution{
    private double height;
    Cylinder(double height, double radius){
        super(height * radius, radius);
    }
    public double getHeight() {
        return height;
    }
}
class Ball extends  SolidOfRevolution{
    Ball(double radius){
        super((4/3) * pi * multiplication(radius, 3), radius);
    }
    static public double multiplication(double a, double n){
        double result = a;
        for (int i = 0; i < n - 1; i++) {
            result*=a;
        }
        return  result;
    }
}
class Box extends shape {
    double used_volume;

    Box(double volume) {
        super(volume);
        used_volume = volume;
    }

    public boolean add(shape figure) {
        if (used_volume - figure.getVolume() > 0) {
            used_volume -= figure.getVolume();
            return true;
        } else {
            return false;
        }
    }
}
    class program2{
    public static void main(String[] args) {
        Ball ball = new Ball(4.5);
        Cylinder cylinder = new Cylinder(2, 2);
        Pyramid pyramid = new Pyramid(100, 100);

        Box box = new Box(1000);
        System.out.println(box.add(ball)); // ok
        System.out.println(box.add(cylinder)); // ok
        System.out.println(box.add(pyramid)); // failed
    }
}
