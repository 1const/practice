package functions.test;

import java.awt.*;

public class MyPolygon {
    MyPoint[] myPoints;
    Color color;
    public MyPolygon(MyPoint... myPoints){
        this.color = Color.ORANGE;
        this.myPoints = myPoints;
    }
    public void render(Graphics graphics){
        Polygon polygon = new Polygon();
        for (int i = 0; i < myPoints.length; i++) {
            Point point = PointConverter.pointConvert(myPoints[i]);
            polygon.addPoint(point.x, point.y);
        }
        graphics.setColor(color);
        graphics.fillPolygon(polygon);
    }
}
