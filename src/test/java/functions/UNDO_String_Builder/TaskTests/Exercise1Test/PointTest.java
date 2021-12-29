package functions.UNDO_String_Builder.TaskTests.Exercise1Test;


import functions.Tasks.Exercise1.Point;
import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void testTestToString() {
        Point point = new Point(2.2, 4.7, 8.4);
        Assert.assertEquals(point.toString(), "[2.2, 4.7, 8.4]");
    }
}