package homework.LongestTriangle;

import java.util.Scanner;

public class Main {

    private static final int TRIANGE_POINT_AMOUNT = 3;

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n < TRIANGE_POINT_AMOUNT) {
            return;
        }

        Point a = new Point(scanner.nextDouble(), scanner.nextDouble());
        Point b = new Point(scanner.nextDouble(), scanner.nextDouble());
        Point c = new Point(scanner.nextDouble(), scanner.nextDouble());

        double lastPerimeter = getTrenglePerimeter(a, b, c);

        for (int i = TRIANGE_POINT_AMOUNT; i < n; i++) {
            var newPoint = new Point(scanner.nextDouble(), scanner.nextDouble());

            var replaceA = getTrenglePerimeter(newPoint, b, c);
            var replaceB = getTrenglePerimeter(a, newPoint, c);
            var replaceC = getTrenglePerimeter(a, b, newPoint);

            if (replaceA > lastPerimeter && replaceA > replaceB && replaceA > replaceC) {
                a = b;
                b = c;
                c = newPoint;
            }

            if (replaceB > lastPerimeter && replaceB > replaceA && replaceB > replaceC) {
                b = c;
                c = newPoint;
            }

            if (replaceC > lastPerimeter && replaceC > replaceB && replaceC > replaceA) {
                c = newPoint;
            }
        }

        System.out.println((int) a.getX() + " " + (int) a.getY());
        System.out.println((int) b.getX() + " " + (int) b.getY());
        System.out.println((int) c.getX() + " " + (int) c.getY());
    }

    private static double getTrenglePerimeter(Point a, Point b, Point c) {
        return a.add(b.negative()).length() + a.add(c.negative()).length() + c.add(b.negative()).length();
    }
}
