import java.time.LocalTime;

public abstract class ClockHand {
    protected double angle; // Kąt obrotu wskazówki

    // 🔹 Metoda ustawiająca czas dla wskazówki
    public abstract void setTime(LocalTime time);

    // 🔹 Metoda generująca kod SVG dla wskazówki zegara
    public abstract String toSvg();
}
