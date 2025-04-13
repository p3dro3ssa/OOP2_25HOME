public class Segment {
    private Point start;
    private Point end;
    public Point getStart(){
        return start;
    }
    public Point getEnd(){
        return  end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }


    public String toString() {
        return start + " -> " + end;
    }

    public double length(){
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2)+ Math.pow(end.getY() - start.getY(), 2));
    }
    public static Segment longestSegment(Segment[] segments){
        if(segments == null || segments.length==0){
            return null;
        }
        Segment longest = segments[0];
        for(Segment s : segments){
            if(s.length() > longest.length()){
                longest = s;
            }
        }
        return longest;
    }
}
