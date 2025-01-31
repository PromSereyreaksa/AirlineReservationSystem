package Booking;

import java.time.LocalDate;
import java.time.LocalTime;

public class PricingSystem {

    // Constants for travel class multipliers
    static final double ECONOMY_CLASS = 1.0;
    static final double BUSINESS_CLASS = 1.5;
    static final double FIRST_CLASS = 2.0;
    // rates not actual price
    // Attributes
    private String source;
    private String destination;
    private String travelClass;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    // Prevents direct modification from outside the class, reducing errors.
    //private: only class can use this

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
    // --------------------*-------------------------

    // Method placeholders
    /*  None of these are static methods because these calculate instance-specific data.
     * so each price and each calculation is based on an instance.
     * they use data that belongs to a specific booking (like source, destination, and travelClass).
     */
    public double calculateFinalPrice(double distance, String travelClass, int availableSeats, int totalSeats, String season, double fuelEfficiency) {
        //calculate every factor combined
        return calculateBasePrice(distance, travelClass) * calculateDemandFactor(availableSeats, totalSeats) *          calculateFuelCostFactor(distance, fuelEfficiency) * calculateSeasonalityFactor(season) * calculateTimeOfBookingFactor();
    }

    public double calculateBasePrice(double distance, String travelClass) {
        return 0.0;
    }

    public double calculateDemandFactor(int availableSeats, int totalSeats) {
        double occupancyRate = (double) (totalSeats - availableSeats) / totalSeats; // Seat occupancy percentage
        if (occupancyRate > 0.8) {  // High demand (80%+ seats booked)
            return 1.5;
        } else if (occupancyRate > 0.5) { // Medium demand (50%-80%)
            return 1.2;
        } else { // Low demand (below 50%)
            return 1.0;
        }
    }

    public  double calculateSeasonalityFactor( String season) {
        if(season.equalsIgnoreCase("winter")){ //equalsIgnoreCase: case insensitive
            return 1.5;
        } else if (season.equalsIgnoreCase("summer")){
            return 1.2;
        } else {
            return 1.0;
        }
    }

    public double calculateTimeOfBookingFactor() {
        return 0.0;
    }

    public double calculateFuelCostFactor(double distance, double fuelEfficiency) {
        return 0.0;
    }

    /* public String calculateTotalTravelTime() {
        return "";

    public  boolean validateTravelClass(String travelClass) {
        if(travelClass.equalsIgnoreCase("economy") || travelClass.equalsIgnoreCase("business") || travelClass.equalsIgnoreCase("first")){
            return true;
        }
        return false;
    }

    public String generateBookingID() {
        return "";
    } */
}
