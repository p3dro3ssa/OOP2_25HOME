import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.time.LocalTime;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DigitalClock clock24 = new DigitalClock(ClockFormat.HOUR_24);
        DigitalClock clock12 = new DigitalClock(ClockFormat.HOUR_12);

        System.out.println("Tryb 24-godzinny: " + clock24);
        System.out.println("Tryb 12-godzinny: " + clock12);


        Map<String, City> cities = City.parseFile("/home/pedro/Downloads/kolokwium1_2024/strefy.csv");
        LocalTime standardTime = LocalTime.of(12, 0, 0);

        List<City> cityList = new ArrayList<>(cities.values());
        cityList.sort(City.worstTimezoneFit(cityList, standardTime));

        System.out.println("Miasta posortowane według największej różnicy czasu:");
        for (City city : cityList) {
            System.out.println(city.getName() + " - Czas miejscowy: " + city.localMeanTime(standardTime));
        }
    }
}

