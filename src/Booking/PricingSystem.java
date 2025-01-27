package Booking;

import java.time.LocalDate;
import java.time.LocalTime;

public class PricingSystem {
    private String source;
    private String destination;
    private String travelClass;
    String source;
    String destination;
    LocalDate departureDate;
    LocalTime departureTime;
    LocalDate arrivalDate;
    LocalTime arrivalTime;
    private final double economyClass = 1.0;
    private final double  businessClass = 1.5;
    private final double  firstClass = 2.0;
    public PricingSystem(double distance, String travelClass){
        this.travelClass = travelClass;
        this.source = source;


    }
    /*
     * route demand, competition, time of booking, cabin class, seasonality, fuel costs, operating costs, and the airline's overall strategy,
     */
    public void calculatePrice(double distance, String travelClass){
        // Economy class: Base rate.
        // Business class: 1.5x base rate.
        // First class: 2x base rate.
        double pricePerKm = 3.0;
        double totalPrice = 0;
        switch(travelClass.toLowerCase()){
            case "economy":
                totalPrice = distance * pricePerKm * economyClass;
                break;
            case "business":
                totalPrice = distance * pricePerKm * businessClass;
                break;
            case "first":
                totalPrice = distance * pricePerKm * firstClass;
                break;
            default:
                System.out.println("Invalid Class");
        }
        System.out.printf("The total price for a %.2f km journey in %s class is: %.2f $ %n", distance, travelClass,totalPrice);

    }

}
