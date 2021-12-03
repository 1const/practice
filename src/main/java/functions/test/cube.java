package functions.test;

import java.awt.*;

public class cube extends MyPolygon {
    private double s;
    MyPolygon[] myPolygons = new MyPolygon[6];

    public cube(double side) {
        this.s = side;
        myPolygons[0] = new MyPolygon(Color.CYAN,
                new MyPoint(0, 0, 0),
                new MyPoint(0, s, 0),
                new MyPoint(0, s, s),
                new MyPoint(0, 0, s)
        );
        myPolygons[1] = new MyPolygon(Color.ORANGE,
                new MyPoint(0, s, 0),
                new MyPoint(-s, s, 0),
                new MyPoint(-s, s, s),
                new MyPoint(0, s, s)
        );
        myPolygons[2] = new MyPolygon(Color.WHITE,
                new MyPoint(0, 0, 0),
                new MyPoint(0, s, 0),
                new MyPoint(-s, s, 0),
                new MyPoint(-s, 0, 0)
        );
        myPolygons[3] = new MyPolygon(Color.MAGENTA,
                new MyPoint(0, 0, 0),
                new MyPoint(-s, 0, 0),
                new MyPoint(-s, 0, s),
                new MyPoint(0, 0, s)
        );
        myPolygons[4] = new MyPolygon(Color.PINK,
                new MyPoint(-s, 0, 0),
                new MyPoint(-s, s, 0),
                new MyPoint(-s, s, s),
                new MyPoint(-s, 0, s)
        );
        myPolygons[5] = new MyPolygon(Color.LIGHT_GRAY,
                new MyPoint(0, 0, s),
                new MyPoint(0, s, s),
                new MyPoint(-s, s, s),
                new MyPoint(-s, 0, s)
        );
    }

    public void render(Graphics graphics) {
        for (MyPolygon p : myPolygons) {
            p.render(graphics);
        }
        sortPolygons();
    }

    private void sortPolygons() {
        MyPolygon.sortPolygons(myPolygons);
    }

    @Override
    public void rotate(double xDegrees, double yDegrees, double zDegrees) {
        for (MyPolygon p : myPolygons) {
            p.rotate(xDegrees, yDegrees, zDegrees);
        }
    }

    @Override
    public void zoom(int w, double k) {
        for (MyPolygon p : myPolygons) {
            p.zoom(w, k);
        }
    }
}

