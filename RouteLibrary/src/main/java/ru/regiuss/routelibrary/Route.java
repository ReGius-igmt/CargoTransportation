package ru.regiuss.routelibrary;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Route {
    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double distance(Collection<Point> points){
        double distance = 0;
        Iterator<Point> iterator = points.iterator();
        if(!iterator.hasNext())return 0;
        Point p = iterator.next();
        Point p2;
        while (iterator.hasNext()){
            p2 = iterator.next();
            distance += p.distanceTo(p2);
            p = p2;
        }
        return distance;
    }



    public static Set<Point> generate(int count){
        if(count <= 0)throw new RuntimeException("count cannot be < 0");
        Set<Point> points = new HashSet<>(count);
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        while (points.size() < count) {
            points.add(new Point(
                    tlr.nextDouble(0, 1000),
                    tlr.nextDouble(0, 1000)
            ));
        }
        return points;
    }

    public static Point getNearestPoint(Point p, Collection<Point> points){
        Iterator<Point> iter = points.iterator();
        if(!iter.hasNext())return null;
        Point p2 = iter.next();
        Point p3;
        while (iter.hasNext()){
            p3 = iter.next();
            if(p.distanceTo(p3) < p.distanceTo(p2))p2 = p3;
        }
        return p2;
    }

    public static void main(String[] args) {
        Set<Point> points = generate(8);
        System.out.println(points);
        System.out.println(distance(points));
    }
}
