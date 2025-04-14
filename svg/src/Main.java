public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(20, 30);
        Point p3 = new Point(40, 10);


        Segment s1 = new Segment(p1, p2);
        Segment s2 = new Segment(p2, p3);
        Segment s3 = new Segment(p3, p1);

        p1.setX(100);
        p1.setY(100);

        System.out.println("Segment po zmianie punktu p1: " + s1);


        Segment longest = Segment.longestSegment(new Segment[]{s1, s2, s3});
        System.out.println("Najdłuższy odcinek: " + longest.getStart() + " -> " + longest.getEnd() + ", długość: " + longest.length());
        Polygon polygon = new Polygon(new Point[]{p1, p2, p3});
        System.out.println(polygon);
        System.out.println(polygon.toSvg());
        Point a = new Point(10, 10);
        Point b = new Point(20, 20);
        Polygon original = new Polygon(new Point[]{a, b});
        Polygon deepCopy = new Polygon(original); // używa głębokiej kopii

        a.setX(999); // modyfikujemy punkt po utworzeniu kopii

        System.out.println("Original: " + original);
        System.out.println("Deep copy: " + deepCopy);

        vgScene scene = new SvgScene();

        Point[] tri1 = {new Point(10, 10), new Point(60, 20), new Point(30, 60)};
        Point[] tri2 = {new Point(100, 100), new Point(150, 120), new Point(130, 160)};
        Point[] tri3 = {new Point(200, 200), new Point(250, 220), new Point(230, 260)};
        Point[] tri4 = {new Point(300, 300), new Point(350, 320), new Point(330, 360)}; // nadpisze pierwszy

        scene.addPolygon(new Polygon(tri1));
        scene.addPolygon(new Polygon(tri2));
        scene.addPolygon(new Polygon(tri3));
        scene.addPolygon(new Polygon(tri4)); // tu zaczyna się nadpisywanie

        System.out.println(scene.toSvg());

    }
}


