package Booking;

import java.time.LocalDate;
import java.time.LocalTime;

public class PricingSystem {

    // Constants for travel class multipliers
    static final double ECONOMY_CLASS = 1.0;
    static final double BUSINESS_CLASS = 1.5;
    static final double FIRST_CLASS = 2.0;

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

    /*
     *
     */

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

    // Method placeholders
    /*  None of these are static methods because these calculate instance-specific data.
     * so each price and each calculation is based on an instance.
     * they use data that belongs to a specific booking (like source, destination, and travelClass).
     */
    public double calculateFinalPrice() {
        //every factor combined
        return 0.0;
    }

    public double calculateBasePrice(double distance, String travelClass) {
        return 0.0;
    }

    public double calculateSeasonalityFactor(String season) {
        return 0.0;
    }

    public double calculateTimeOfBookingFactor() {
        return 0.0;
    }

    public double calculateFuelCostFactor(double distance, double fuelEfficiency) {
        return 0.0;
    }

    public String calculateTotalTravelTime() {
        return "";
    }

    public boolean validateTravelClass(String travelClass) {
        return false;
    }

    public String generateBookingID() {
        return "";
    }
}
