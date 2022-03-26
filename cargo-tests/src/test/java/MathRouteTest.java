import org.junit.Assert;
import org.junit.Test;
import ru.regiuss.cargotransportation.mathroute.MathRoute;
import ru.regiuss.cargotransportation.mathroute.Point;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MathRouteTest {
    @Test
    public void generatePointsCountTest1(){
        Set<Point> points = MathRoute.generate(11);
        assertEquals(points.size(), 11);
    }

    @Test
    public void generatePointsCountTest2(){
        RuntimeException e = assertThrows(RuntimeException.class, () -> MathRoute.generate(-4));
        assertEquals(e.getMessage(), "count was not be < 1");
    }

    @Test
    public void distancePointsTest1(){
        List<Point> points = List.of(
                new Point(0.0, 0.0),
                new Point(0.0, 5.0),
                new Point(5.0, 5.0)
        );
        assertEquals(MathRoute.distance(points), 10, 0);
    }

    @Test
    public void distancePointsTest2(){
        Set<Point> points = Collections.emptySet();
        assertEquals(MathRoute.distance(points), 0, 0);
    }
}
