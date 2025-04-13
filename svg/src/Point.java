public class Point {
    private float x;
    private float y;
    public Point(){
        this.x = 0.0f;
        this.y = 0.0f;
    }
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public String toString(){
        return "Point(" + x+ "," + y + ")";
    }
    public String toSvg(){
        return "<circle cx='"+ x + "' cy='" + y + "' r='2' fill='black' />";
    }
    public void translate(float dx, float dy){
        this.x += dx;
        this.y +=dy;
    }
    public Point translated(float dx, float dy){
        Point newPoint = new Point();
        newPoint.x = x + dx;
        newPoint.y = y + dy;
        return newPoint;
    }


}
