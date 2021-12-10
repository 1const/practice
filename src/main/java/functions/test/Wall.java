package functions.test;

import java.awt.*;

public class Wall extends MyPolygon{
    MyPolygon polygon;
    private double a;
    public Wall(MyPolygon polygon){
        this.polygon = polygon;
        a = polygon.myPoints[0].y;
        polygon.setColor(Color.RED);
    }
    public boolean check(cube cube){
        for (int i = 0; i < cube.myPolygons.length; i++) {
            for (int j = 0; j < cube.myPolygons[i].getMyPoints().length; j++)
                if(cube.myPolygons[i].getMyPoints()[j].y == a){
                    return false;
                }
        }
        return true;
    }
    @Override
    public void render(Graphics graphics) {
        polygon.render(graphics);
    }
}
