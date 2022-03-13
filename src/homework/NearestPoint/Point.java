package homework.NearestPoint;

public final class Point {
    private final double x;
    private final double y;

    public Point(double vX, double vY) {
        this.x = vX;
        this.y = vY;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public Point add(Point another) {
        return new Point(x + another.x, y + another.y);
    }

    public Point add(double value) {
        return new Point(x + value, y + value);
    }

    public Point subtract(Point another) {
        return new Point(x - another.x, y - another.y);
    }

    public Point subtract(double value) {
        return new Point(x - value, y - value);
    }

    public Point multiply(Point another) {
        return new Point(x * another.x, y * another.y);
    }

    public Point multiply(double value) {
        return new Point(x * value, y * value);
    }

    public Point divide(Point another) {
        return new Point(x / another.x, y / another.y);
    }

    public Point divide(double value) {
        return new Point(x / value, y / value);
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }
}
