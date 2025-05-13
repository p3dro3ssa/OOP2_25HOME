public class DigitalClock extends Clock{
    private ClockFormat format;

    public DigitalClock(ClockFormat format){
        this.format = format;
        setCurrentTime();
    }
    @Override
    public String toString(){
        if (format == ClockFormat.HOUR_24){
            return super.toString();
        }else{
            return format12hour();
        }
    }
    private String format12hour(){
        int displayHour = super.hours % 12;
        displayHour = (displayHour == 0) ? 12 : displayHour;
        String period = (super.hours < 12) ? "AM" : "PM";

        return String.format("%d:%02d:%02d %s", displayHour, super.minutes, super.seconds, period);
    }
}
