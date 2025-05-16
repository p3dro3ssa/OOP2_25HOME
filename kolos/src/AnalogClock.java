import java.io.FileWriter;
import java.io.IOException;
public class AnalogClock {
    super(); // Wywołanie konstruktora klasy bazowej
}

// 🔹 Metoda zapisująca tarczę zegara do pliku SVG
public void toSvg(String filePath) {
    String svgContent = generateSvgContent();

    try (FileWriter writer = new FileWriter(filePath)) {
        writer.write(svgContent);
        System.out.println("Zapisano tarczę zegara do pliku SVG: " + filePath);
    } catch (IOException e) {
        System.err.println("Błąd zapisu pliku SVG: " + e.getMessage());
    }
}

// 🔹 Metoda generująca kod SVG dla tarczy zegara (bez wskazówek)
private String generateSvgContent() {
    return """
            <svg width="200" height="200" viewBox="0 0 200 200" xmlns="http://www.w3.org/2000/svg">
                <circle cx="100" cy="100" r="95" fill="white" stroke="black" stroke-width="5"/>
                <circle cx="100" cy="100" r="5" fill="black"/>
            </svg>
        """;
}

