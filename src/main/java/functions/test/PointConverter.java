package functions.test;

import java.awt.Point;

public class PointConverter {
    public static Point pointConvert(MyPoint myPoint3D){
        int x = Display.WEIGH / 2+ myPoint3D.y;
        int y = Display.HEIGHT / 2 - myPoint3D.z;
        return new Point(x,y);
    }
}
