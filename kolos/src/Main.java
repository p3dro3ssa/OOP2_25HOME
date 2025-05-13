//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DigitalClock clock24 = new DigitalClock(ClockFormat.HOUR_24);
        DigitalClock clock12 = new DigitalClock(ClockFormat.HOUR_12);

        System.out.println("Tryb 24-godzinny: " + clock24);
        System.out.println("Tryb 12-godzinny: " + clock12);
    }
}
