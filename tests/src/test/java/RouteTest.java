import org.junit.Test;
import org.junit.Assert;
import ru.regiuss.Point;
import ru.regiuss.Route;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RouteTest {
    @Test
    public void generateCountTest1(){
        Set<Point> points = Route.generate(8);
        assertEquals(points.size(), 8);
    }

    @Test
    public void generateCountTest2(){
        Exception e = assertThrows(RuntimeException.class, () -> {
            Route.generate(-4);
        });
        assertEquals("count cannot be < 0", e.getMessage());
    }

    @Test
    public void pointsDistanceTest(){
        Point a = new Point(0,0);
        Point b = new Point(0,4);
        assertEquals(a.distanceTo(b), 4, 0);
    }

    @Test
    public void multiPointsDistanceTest(){
        List<Point> points = List.of(
                new Point(0,0),
                new Point(0,4),
                new Point(0,8),
                new Point(0,15)
        );
        assertEquals(Route.distance(points), 15, 0);
    }

    @Test
    public void nearestPointTest(){
        Point p = new Point(0,15);
        List<Point> points = List.of(
                new Point(0,0),
                new Point(0,4),
                new Point(0,8),
               p
        );
        assertEquals(Route.getNearestPoint(new Point(0,15), points), p);
    }
}
