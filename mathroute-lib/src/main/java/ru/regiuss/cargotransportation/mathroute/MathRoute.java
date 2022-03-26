package ru.regiuss.cargotransportation.mathroute;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MathRoute {
    public static double distance(Collection<Point> points){
        if(points.isEmpty())return 0;
        double distance = 0;
        Iterator<Point> iterator = points.iterator();
        Point current = iterator.next();
        while (iterator.hasNext())
            distance += current.distanceTo((current = iterator.next()));
        return distance;
    }

    public static Set<Point> generate(int count){
        if(count < 1)throw new RuntimeException("count was not be < 1");
        Set<Point> points = new HashSet<>();
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        for (int i = 0; i < count;) {
            if(points.add(new Point(
                    tlr.nextDouble(1000),
                    tlr.nextDouble(1000)
            )))i++;
        }
        return points;
    }
}
