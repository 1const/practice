package functions.test;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MyPolygon {
    MyPoint[] myPoints;
    private Color color;
    private Color lightColor;
    private static final double AMBIENT_LIGHT = 0.05;
    public MyPolygon(MyPoint... myPoints) {
        this.myPoints = myPoints;
    }

    public MyPolygon(Color color, MyPoint... myPoints) {
        this.color = color;
        this.lightColor = color;
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

        graphics.setColor(this.lightColor);
        graphics.fillPolygon(polygon);
    }

    public void rotate(double xDegrees, double yDegrees, double zDegrees, MyVector lightVector) {
        for (MyPoint point : myPoints) {
            PointConverter.rotateX(point, xDegrees);
            PointConverter.rotateY(point, yDegrees);
            PointConverter.rotateZ(point, zDegrees);
        }
        this.updateLightingRatio(lightVector);
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
    private void updateLightingRatio(MyVector lightVector){
        if (this.myPoints.length < 3){
            return;
        }
        MyVector v1 = new MyVector(this.myPoints[0], this.myPoints[1]);
        MyVector v2 = new MyVector(this.myPoints[1], this.myPoints[2]);
        MyVector normal = MyVector.normalize(MyVector.vector(v2, v1));
        double scalar = MyVector.scalar(normal, lightVector);
        double sign = scalar < 0 ? -1 : 1;
        scalar = sign * scalar * scalar;
        scalar = (scalar + 1) / 2 * (1 - AMBIENT_LIGHT);
        
        double lightRatio = Math.min(1, Math.max(0, AMBIENT_LIGHT + scalar));
        this.updateLightingColor(AMBIENT_LIGHT + scalar);
    }
    private void updateLightingColor(double lightRatio){
        int red = (int) (this.color.getRed() * lightRatio);
        int green = (int) (this.color.getGreen() * lightRatio);
        int blue = (int) (this.color.getBlue() * lightRatio);
        this.lightColor = new Color(red, green, blue);
    }
}
