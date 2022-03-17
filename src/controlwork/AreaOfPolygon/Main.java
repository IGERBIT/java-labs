package controlwork.AreaOfPolygon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Point> edges = new ArrayList<>();


        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            edges.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }

        var p1 = edges.get(0);

        double square = 0;

        for (int i = 1; i < n - 1; i++) {
            var p2 = edges.get(i);
            var p3 = edges.get(i + 1);

            square += getTriangleSquare(p1,p2,p3);
        }

        System.out.printf("%.1f", square);

    }

    public static double getTriangleSquare(Point p1, Point p2, Point p3) {
        double a = Math.sqrt((p2.getX() - p1.getX()) * (p2.getX() - p1.getX()) + (p2.getY() - p1.getY()) * (p2.getY() - p1.getY()));
        double b = Math.sqrt((p3.getX() - p2.getX()) * (p3.getX() - p2.getX()) + (p3.getY() - p2.getY()) * (p3.getY() - p2.getY()));
        double c = Math.sqrt((p3.getX() - p1.getX()) * (p3.getX() - p1.getX()) + (p3.getY() - p1.getY()) * (p3.getY() - p1.getY()));

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
