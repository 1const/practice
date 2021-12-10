package functions.test;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MyPolygon {
    MyPoint[] myPoints;
    private Color color = Color.cyan;

    public MyPolygon(MyPoint... myPoints) {
        this.myPoints = myPoints;
    }

    public MyPolygon(Color color, MyPoint... myPoints) {
        this.color = color;
        this.myPoints = myPoints;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public MyPoint[] getMyPoints() {
        return myPoints;
    }

    public Color getColor() {
        return color;
    }

    public void render(Graphics graphics) {
        Polygon polygon = new Polygon();
        for (int i = 0; i < myPoints.length; i++) {
            Point point = PointConverter.pointConvert(myPoints[i]);
            polygon.addPoint(point.x, point.y);
        }
        graphics.setColor(color);
        graphics.fillPolygon(polygon);
    }

    public void rotate(double xDegrees, double yDegrees, double zDegrees) {
        for (MyPoint point : myPoints) {
            PointConverter.rotateX(point, xDegrees);
            PointConverter.rotateY(point, yDegrees);
            PointConverter.rotateZ(point, zDegrees);
        }
    }

    public double getAverageX() {
        double sum = 0;
        for (MyPoint p : myPoints) {
            sum += p.x;
        }
        return sum / myPoints.length;
    }
    public void zoom(int w, double k){
        double sum = Arrays.stream(myPoints).mapToDouble(point -> point.x).sum();
        for(MyPoint p: myPoints){
            p.x += w*k;
        }
    }
    public void bias(int deltaX, int deltaY){
        for(MyPoint p: myPoints){
            p.z -= deltaX;
            p.y += deltaY;
        }
    }
    public static MyPolygon[] sortPolygons(MyPolygon[] myPolygons) {
        List<MyPolygon> polygonList = Arrays.asList(myPolygons);

        polygonList.sort((MyPolygon a, MyPolygon b) -> {
            return a.getAverageX() > b.getAverageX() ? 1 : -1;
        });

        return polygonList.toArray(new MyPolygon[0]);
    }
}
