package functions.test;

import java.awt.Point;

public class PointConverter {
    public static Point pointConvert(MyPoint myPoint3D) {
        int x = (int) (Display.WEIGH / 2 + myPoint3D.y);
        int y = (int) (Display.HEIGHT / 2 - myPoint3D.z);
        return new Point(x, y);
    }

    public static void rotateX(MyPoint point, double velocityX) {
        double vector = Math.sqrt(point.y * point.y + point.z * point.z);
        double a = Math.atan2(point.y, point.z);
        a += (Math.PI / 180) * velocityX;
        point.y = vector * Math.sin(a);
        point.z = vector * Math.cos(a);
    }

    public static void rotateY(MyPoint point, double velocityY) {
        double vector = Math.sqrt(point.x * point.x + point.z * point.z);
        double a = Math.atan2(point.x, point.z);
        a += (Math.PI / 180) * velocityY;
        point.x = vector * Math.sin(a);
        point.z = vector * Math.cos(a);
    }

    public static void rotateZ(MyPoint point, double velocityZ) {
        double vector = Math.sqrt(point.x * point.x + point.y * point.y);
        double a = Math.atan2(point.x, point.y);
        a += (Math.PI / 180) * velocityZ;
        point.x = vector * Math.sin(a);
        point.y = vector * Math.cos(a);
    }
}
