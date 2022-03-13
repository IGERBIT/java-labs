package homework.NearestPoint;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
        }

        var center = Arrays.stream(points).reduce(Point::add).orElse(new Point(0, 0));

        center = center.divide(n);

        if (center.getX() == (int) center.getX() && center.getY() == (int) center.getY()) {
            System.out.println((int) center.getX() + " " + (int) center.getY());
            return;
        }

        var ceilCenter = new Point(Math.ceil(center.getX()), Math.ceil(center.getY()));
        var floorCenter = new Point(Math.floor(center.getX()), Math.floor(center.getY()));

        if (totalDistanceToPoints(ceilCenter, points) < totalDistanceToPoints(floorCenter, points)) {
            System.out.println((int) ceilCenter.getX() + " " + (int) ceilCenter.getY());
        } else {
            System.out.println((int) floorCenter.getX() + " " + (int) floorCenter.getY());
        }

    }

    private static double totalDistanceToPoints(Point point, Point[] arr) {
        var negativePoint = point.multiply(-1);
        return Arrays.stream(arr).reduce(0.0, (acc, value) -> acc + value.add(negativePoint).length(), Double::sum);
    }
}
