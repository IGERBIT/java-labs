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

        Point ceilXceilYCenter = new Point(Math.ceil(center.getX()), Math.ceil(center.getY()));
        Point floorXfloorYCenter = new Point(Math.floor(center.getX()), Math.floor(center.getY()));
        Point floorXceilYCenter = new Point(Math.floor(center.getX()), Math.ceil(center.getY()));
        Point ceilXfloorYCenter = new Point(Math.ceil(center.getX()), Math.floor(center.getY()));

        double ceilXceilYCenterDistance  = totalDistanceToPoints(ceilXceilYCenter, points);
        double floorXfloorYCenterDistance = totalDistanceToPoints(floorXfloorYCenter, points);
        double floorXceilYCenterDistance = totalDistanceToPoints(floorXceilYCenter, points);
        double ceilXfloorYCenterDistance = totalDistanceToPoints(ceilXfloorYCenter, points);

        double minDistance = Math.min(Math.min(ceilXceilYCenterDistance, floorXfloorYCenterDistance), Math.min(floorXceilYCenterDistance, ceilXfloorYCenterDistance));

        if (minDistance == ceilXceilYCenterDistance) {
            System.out.println((int) ceilXceilYCenter.getX() + " " + (int) ceilXceilYCenter.getY());
            return;
        }

        if (minDistance == floorXfloorYCenterDistance) {
            System.out.println((int) floorXfloorYCenter.getX() + " " + (int) floorXfloorYCenter.getY());
            return;
        }

        if (minDistance == floorXceilYCenterDistance) {
            System.out.println((int) floorXceilYCenter.getX() + " " + (int) floorXceilYCenter.getY());
            return;
        }
        System.out.println((int) ceilXfloorYCenter.getX() + " " + (int) ceilXfloorYCenter.getY());
    }

    private static double totalDistanceToPoints(Point point, Point[] arr) {
        var negativePoint = point.multiply(-1);
        return Arrays.stream(arr).reduce(0.0, (acc, value) -> acc + value.add(negativePoint).length(), Double::sum);
    }
}
