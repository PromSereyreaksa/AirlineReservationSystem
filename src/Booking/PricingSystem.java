package Booking;

import java.time.LocalDate;
import java.time.LocalTime;

public class PricingSystem {

    // Constants for travel class multipliers
    static final double economyClass = 1.0; // to be adjusted
    static final double businessClass = 1.5; // to be adjusted
    static final double firstClass = 2.0; // to be adjusted
    // rates not actual price
    // Attributes
    private double ratePerMile;
    private String source;
    private String destination;
    private String travelClass;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    // Prevents direct modification from outside the class, reducing errors.
    //private: only this class can use this

    // Constructor
    public PricingSystem(String source, String destination, String travelClass, double ratePerMile,
            LocalDate departureDate, LocalDate arrivalDate,
            LocalTime departureTime, LocalTime arrivalTime) {
        this.source = source;
        this.destination = destination;
        this.travelClass = travelClass;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.ratePerMile = ratePerMile;
        /*
         * to be implemented:
         * get distance from source and destination.
         */
    }
    public PricingSystem(String source, String destination, String travelClass,double ratePerMile){
        this.source = source;
        this.destination = destination;
        this.travelClass = travelClass;
        this.ratePerMile = ratePerMile;
        //basefare
    }

    public double calculateRatePerMile(double distance) {
        if (distance >= 5000) {
            // Long haul flight
            return 0.15;
        } else if (distance >= 2000) {
            // Medium haul flight
            return 0.30;
        } else {
            // Short haul flight
            return 0.50;
        }
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
        // distance = length between source and destination but returned in kilometer
        // price is to be adjusted
        return 0.0; // distance * travelClass;
    }

    public double calculateDemandFactor(int availableSeats, int totalSeats) {
        // occupancyrate = available seat left
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
        if(season.equalsIgnoreCase("winter")){
             //equalsIgnoreCase: case insensitive
             // holiday seasons..
             // harsh weathers
            return 1.5;
        } else if (season.equalsIgnoreCase("summer")){
            return 1.2;
        } else {
            return 1.0;
        }
    }

    public double calculateTimeOfBookingFactor() {
        // if night -> more expensive and vice versa
        return 0.0;
    }

    public double calculateFuelCostFactor(double distance, double fuelEfficiency) {
        // given the distance of the flight -> determine the amount of fuel required for the flight -> multiply it by   the cost of fuel per unit
        return 0.0;
    }


    public boolean validateTravelClass(String travelClass) {
        // check if they enter a valid or invalid class
        // could just show a list of class to be selected later (WIP)
        if(travelClass.equalsIgnoreCase("economy") || travelClass.equalsIgnoreCase("business") || travelClass.equalsIgnoreCase("first")){
            return true;
        }
        return false;
    }

    /* public String calculateTotalTravelTime() {
        return "";



    public String generateBookingID() {
        return "";
    } */
}
