public class SvgScene {
    private Polygon[] polygons;
    private int nextIndex;
    public SvgScene(){
        this.polygons = new Polygon[3];
        this.nextIndex = 0;
    }
    public void addPolygon(Polygon p) {
        polygons[nextIndex] = p;
        nextIndex = (nextIndex + 1) % polygons.length; // przeskok cykliczny (0 -> 1 -> 2 -> 0 -> ...)
    }

    public String toSvg() {
        StringBuilder sb = new StringBuilder();
        sb.append("<svg xmlns='http://www.w3.org/2000/svg' width='500' height='500'>\n");
        for (Polygon p : polygons) {
            if (p != null) {
                sb.append(p.toSvg()).append("\n");
            }
        }
        sb.append("</svg>");
        return sb.toString();
    }
}
