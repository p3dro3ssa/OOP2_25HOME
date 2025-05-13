public abstract class Clock {
    public int hours;
    public int minutes;
    public int seconds;
    public void setCurrentTime(){
        java.time.LocalTime now = java.time.LocalTime.now();
        this.hours = now.getHour();
        this.minutes = now.getMinute();
        this.seconds = now.getSecond();
    }
    public void setTime( int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    @Override
    public String toString(){
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
