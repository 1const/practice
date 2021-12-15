package functions.test;

public class MyVector {
    public double x;
    public double y;
    public double z;

    public MyVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public MyVector(MyPoint a, MyPoint b){
        this.x = b.x - a.x;
        this.y = b.y - a.y;
        this.z = b.z - a.z;
    }
    public double module(){
        return Math.sqrt(this.x * this.x
                + this.y * this.y
                + this.z * this.z);
    }
    public static double scalar(MyVector v1, MyVector v2){
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }
    public static MyVector vector(MyVector v1, MyVector v2){
        return new MyVector(
                v1.y * v2.z - v2.y * v1.z,
                v1.z * v2.x - v2.z * v1.x,
                v1.x * v2.y - v2.x * v1.y);
    }
    public static MyVector normalize(MyVector v){
        return new MyVector(
                v.x / v.module(),
                v.y / v.module(),
                v.z / v.module());
    }
}
