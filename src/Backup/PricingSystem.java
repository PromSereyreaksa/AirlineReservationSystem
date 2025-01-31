package Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PricingSystem {

    // Constants for travel class multipliers
    private static final double ECONOMY_CLASS = 1.0;
    private static final double BUSINESS_CLASS = 1.5;
    private static final double FIRST_CLASS = 2.0;
    // to be implemented:
    /*
     * add class
     * upgrade class
     * refund
     * flight discounts (delays)
     */

    // Attributes
    private String source;
    private String destination;
    private String travelClass;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;

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

    // Main method for testing
    public static void main(String[] args) {
        // Test case for a single flight
        PricingSystem pricingSystem = new PricingSystem("India", "United States", "economy",
                LocalDate.of(2022, 6, 1), LocalDate.of(2022, 6, 2),
                LocalTime.of(10, 0), LocalTime.of(12, 0));

        double distance = Distance.getDistance("India", "United States");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Base price: " + pricingSystem.calculateBasePrice(distance, "economy"));
        System.out.println("Final price: " + pricingSystem.calculateFinalPrice());
        System.out.println("Total travel time: " + pricingSystem.calculateTotalTravelTime());
        System.out.println("Booking ID: " + pricingSystem.generateBookingID());

        // Check if the flight has two stops (distance > 3000 km)
        if (distance > 3000) {
            System.out.println("This flight has two stops due to the long distance.");
        }
    }

    // Function to calculate final price including all factors
    public double calculateFinalPrice() {
        double distance = Distance.getDistance(source, destination);
        double basePrice = calculateBasePrice(distance, travelClass);
        double seasonalityFactor = calculateSeasonalityFactor("summer");
        double timeOfBookingFactor = calculateTimeOfBookingFactor();
        double fuelCostFactor = calculateFuelCostFactor(distance, 10.0);

        return basePrice * seasonalityFactor * timeOfBookingFactor * fuelCostFactor;
    }

    // Function to calculate base price based on distance and travel class
    public double calculateBasePrice(double distance, String travelClass) {
        double pricePerKm = 3.0;
        if (travelClass.isEmpty() || distance == -1 || !validateTravelClass(travelClass)) {
            return -1.0;
        }

        double classMultiplier = getClassMultiplier(travelClass);
        return distance * pricePerKm * classMultiplier;
    }

    // Helper function to get class multiplier
    private double getClassMultiplier(String travelClass) {
        switch (travelClass.toLowerCase()) {
            case "economy":
                return ECONOMY_CLASS;
            case "business":
                return BUSINESS_CLASS;
            case "first":
                return FIRST_CLASS;
            default:
                return -1.0;
        }
    }

    // Function to calculate seasonality factor
    public double calculateSeasonalityFactor(String season) {
        switch (season.toLowerCase()) {
            case "summer":
                return 2.0;
            case "winter":
                return 1.5;
            default:
                return 1.0;
        }
    }

    // Function to calculate time of booking factor
    public double calculateTimeOfBookingFactor() {
        if (departureDate.isBefore(LocalDate.now().plusDays(7))) {
            return 1.7;
        } else if (departureDate.isBefore(LocalDate.now().plusDays(14))) {
            return 1.3;
        } else if (departureDate.isBefore(LocalDate.now().plusDays(30))) {
            return 1.0;
        }
        return 0.8; // Discount for booking more than 30 days in advance
    }

    // Function to calculate fuel cost factor
    public double calculateFuelCostFactor(double distance, double fuelEfficiency) {
        double fuelCost = (distance / fuelEfficiency) * 0.547;
        return fuelCost > 100 ? 1.2 : 1.0;
    }

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

    // Function to generate booking ID
    public String generateBookingID() {
        return "BK" + departureDate.getYear() + departureDate.getMonthValue()
                + departureDate.getDayOfMonth() + (int) (Math.random() * 1000);
    }
}
