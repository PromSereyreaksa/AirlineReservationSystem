package Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PricingSystem {

    // Attributes
    private String source;
    private String destination;
    private String travelClass;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private static double economyClass = 1.0;
    private static double businessClass = 1.5;
    private static double firstClass = 2.0;

    // Constructor
    public PricingSystem(String source, String destination, String travelClass,
            LocalDate departureDate, LocalDate arrivalDate,
            LocalTime departureTime, LocalTime arrivalTime) {
        this.source = source;
        this.destination = destination;
        this.travelClass = travelClass;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Function to calculate final price including all factors
    public double calculateFinalPrice() {
        double distance = Distance.getDistance(source, destination);
        double basePrice = calculateBasePrice(distance, travelClass);
        double seasonalityFactor = calculateSeasonalityFactor("summer");
        double timeOfBookingFactor = calculateTimeOfBookingFactor();
        double fuelCostFactor = calculateFuelCostFactor(distance, 10.0);
        // double airlineStrategyFactor = calculateAirlineStrategyFactor();
        // double operatingCostFactor = calculateOperatingCostFactor();
        // double demandFactor = calculateDemandFactor();
        // double competitionFactor = calculateCompetitionFactor();

        return basePrice * seasonalityFactor * timeOfBookingFactor * fuelCostFactor;
    }

    // Function to calculate base price based on distance and travel class
    public double calculateBasePrice(double distance, String travelClass) {
        double pricePerKm = 3.0;
        double totalPrice = 0;
        if (travelClass.isEmpty()) {
            return -1;
        } else if (distance == -1) {
            return -1;
        } else if (!travelClass.equals("economy") && !travelClass.equals("business") && !travelClass.equals("first")) {
            return -1;
        }

        if (travelClass.equalsIgnoreCase("economy")) {
            totalPrice = distance * pricePerKm * economyClass;
        } else if (travelClass.equalsIgnoreCase("business")) {
            totalPrice = distance * pricePerKm * businessClass;
        } else if (travelClass.equalsIgnoreCase("first")) {
            totalPrice = distance * pricePerKm * firstClass;
        }
        return totalPrice;
    }

    // Function to calculate demand factor (skeleton)
    /*  public double calculateDemandFactor() {
        // Logic to be implemented
        return 1.0;
    } */

    // Function to calculate seasonality factor (skeleton)
    public double calculateSeasonalityFactor(String season) {
        if (season.equalsIgnoreCase("summer")) {
            return 2;
        } else if (season.equalsIgnoreCase("winter")) {
            return 1.5;
        } else {
            return 1.0;
        }
    }

    // Function to calculate competition factor (skeleton)
    /*  public double calculateCompetitionFactor() {
        // Logic to be implemented
        return 1.0;
    } */
    // Function to calculate time of booking factor (skeleton)
    public double calculateTimeOfBookingFactor() {
        if (departureDate.isBefore(LocalDate.now().plusDays(7))) {
            return 1.7;
        } else if (departureDate.isBefore(LocalDate.now().plusDays(14))) {
            return 1.3;
        } else if (departureDate.isBefore(LocalDate.now().plusDays(30))) {
            return 1.0;
        }
        return 0.8;
        //  if customer book earlier than 30+ days we have discounted price
    }

    // Function to calculate fuel cost factor (skeleton)
    public double calculateFuelCostFactor(double distance, double fuelEfficiency) {
        // Calculate the fuel cost factor based on fuel price, distance, and efficiency
        double fuelCost = (distance / fuelEfficiency) * 0.547;
        // Normalize or adjust the factor as needed
        return fuelCost > 100 ? 1.2 : 1.0; // Example: Apply a 1.2x factor if fuel cost exceeds 100
    }

    // Function to calculate operating cost factor (skeleton)
    /* public double calculateOperatingCostFactor() {
        // Logic to be implemented
        return 1.0;
    } */
    // Function to calculate total travel time
    public String calculateTotalTravelTime() {
        long hours = ChronoUnit.HOURS.between(departureTime, arrivalTime);
        long minutes = ChronoUnit.MINUTES.between(departureTime, arrivalTime) % 60;
        return hours + " hours and " + minutes + " minutes";
    }

    // Function to validate travel class
    public boolean validateTravelClass(String travelClass) {
        return travelClass.equalsIgnoreCase("economy")
                || travelClass.equalsIgnoreCase("business")
                || travelClass.equalsIgnoreCase("first");
    }

    // Function to validate date and time
    public boolean validateDateTime(LocalDate date, LocalTime time) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        return !date.isBefore(currentDate) && !(date.isEqual(currentDate) && time.isBefore(currentTime));
    }

    // Function to generate booking ID (skeleton)
    public String generateBookingID() {
        // Logic to be implemented
        return "BK" + departureDate.getYear() + departureDate.getMonthValue()
                + departureDate.getDayOfMonth() + (int) (Math.random() * 1000);
    }
}
