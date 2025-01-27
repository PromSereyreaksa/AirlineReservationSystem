import static Booking.Distance.getDistance;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter country 1: ");
        String country1 = input.nextLine();
        System.out.printf("Enter country 2: ");
        String country2 = input.nextLine();
        double distance = getDistance(country1,country2);
        System.out.println(distance);
    }
}
