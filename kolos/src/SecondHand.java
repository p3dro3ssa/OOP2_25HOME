import java.time.LocalTime;

public class SecondHand extends ClockHand {
    private static final double DEGREES_PER_SECOND = 6.0; // Każda sekunda to 6 stopni
    private static final int LENGTH = 90; // Długość wskazówki
    private static final int THICKNESS = 2; // Grubość wskazówki
    private static final String COLOR = "red"; // Kolor wskazówki

    public SecondHand() {
        this.angle = 0; // Domyślnie ustawiona na 0 stopni
    }

    @Override
    public void setTime(LocalTime time) {
        int seconds = time.getSecond();
        this.angle = seconds * DEGREES_PER_SECOND; // Obliczanie kąta na podstawie sekund
    }

    @Override
    public String toSvg() {
        double x2 = 100 + LENGTH * Math.sin(Math.toRadians(angle));
        double y2 = 100 - LENGTH * Math.cos(Math.toRadians(angle));

        return String.format("<line x1='100' y1='100' x2='%.2f' y2='%.2f' stroke='%s' stroke-width='%d'/>",
                x2, y2, COLOR, THICKNESS);
    }
}
