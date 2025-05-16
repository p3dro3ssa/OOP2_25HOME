import java.io.*;
import java.util.*;
import java.time.LocalTime;

public class City {
    private String name;
    private int summerTimeZone;
    private double latitude;
    private double longitude;

    public City(String name, int summerTimeZone, double latitude, double longitude) {
        this.name = name;
        this.summerTimeZone = summerTimeZone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() { return name; }
    public int getSummerTimeZone() { return summerTimeZone; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    public static Map<String, City> parseFile(String filePath) {
        Map<String, City> cities = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Pomijamy pierwszą linię (nagłówki)

            while ((line = br.readLine()) != null) {
                City city = parseLine(line);
                cities.put(city.getName(), city);
            }
        } catch (IOException e) {
            System.err.println("Błąd odczytu pliku: " + e.getMessage());
        }

        return cities;
    }

    private static City parseLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Niepoprawny format danych: " + line);
        }

        String name = parts[0].trim();
        int summerTimeZone = Integer.parseInt(parts[1].trim());
        double latitude = parseCoordinate(parts[2].trim());
        double longitude = parseCoordinate(parts[3].trim());

        return new City(name, summerTimeZone, latitude, longitude);
    }

    private static double parseCoordinate(String coord) {
        coord = coord.replace("N", "").replace("S", "-").replace("E", "").replace("W", "-").trim();
        return Double.parseDouble(coord);
    }

    public LocalTime localMeanTime(LocalTime standardTime) {
        double timeOffset = (longitude / 180.0) * 12.0;
        return standardTime.plusSeconds((long) (timeOffset * 3600));
    }

    public static Comparator<City> worstTimezoneFit(List<City> cityList, LocalTime standardTime) {
        return Comparator.comparingDouble((City city) -> {
            LocalTime cityMeanTime = city.localMeanTime(standardTime);
            return Math.abs(cityMeanTime.toSecondOfDay() - standardTime.toSecondOfDay());
        }).reversed();
    }

    @Override
    public String toString() {
        return String.format("%s - Strefa: %d, Szerokość: %.4f, Długość: %.4f",
                name, summerTimeZone, latitude, longitude);
    }
}
