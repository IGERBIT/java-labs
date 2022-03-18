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

        double minDistance = 0;
        Point nearestPoint = null;

        for (Point point : points) {
            var distance = point.subtract(center).length();

            if(nearestPoint == null) {
                minDistance = distance;
                nearestPoint = point;
                continue;
            }

            if(distance < minDistance) {
                minDistance = distance;
                nearestPoint = point;
            }
        }

        if(nearestPoint != null) {
            System.out.println((int) nearestPoint.getX() + " " + (int) nearestPoint.getY());
        }

    }

    private static double totalDistanceToPoints(Point point, Point[] arr) {
        var negativePoint = point.multiply(-1);
        return Arrays.stream(arr).reduce(0.0, (acc, value) -> acc + value.add(negativePoint).length(), Double::sum);
    }
}
