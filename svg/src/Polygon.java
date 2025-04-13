public class Polygon {
    private Point[] points;
    public Polygon(Point[] points) {
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point(points[i]); // kopiujemy każdy punkt
        }
    }
    public Polygon(Polygon other) {
        this.points = new Point[other.points.length];
        for (int i = 0; i < other.points.length; i++) {
            this.points[i] = new Point(other.points[i]); // konstruktor kopiujący Point
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Polygon: ");
        for (Point p : points) {
            sb.append(p.toString()).append(" ");
        }
        return sb.toString();
    }

    public String toSvg() {
        StringBuilder sb = new StringBuilder("<polygon points='");
        for (Point p : points) {
            sb.append(p.getX()).append(",").append(p.getY()).append(" ");
        }
        sb.append("' fill='none' stroke='black' />");
        return sb.toString();
    }
}

