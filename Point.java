public class Point implements Comparable<Point> {
    public int x, y;
    public int dist;
    public Point prev;

    public Point(int x, int y, Point prev) {
        this.x = x;
        this.y = y;
        this.prev = prev;
        this.dist = distance(this, Screen.goal);
    }

    public static int distance(Point a, Point b) {
        if (b == null) {
            return 0;
        }
        return (int)Math.hypot(b.x - a.x, b.y - a.y);
    }

    @Override
    public int compareTo(Point other) {
        return dist - other.dist;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        return 9*y + x;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point casted = (Point)o;
        return casted.x == x && casted.y == y;
    }
}
