package Booking;

import java.time.LocalDateTime;

import Flight.FlightManagement;

public class Ticket {
    String ticketId;
    FlightManagement flight;
    Passenger passenger;
    String seatNumber;
    LocalDateTime bookingDateTime;
    String ticketStatus;
    double totalFare;

    // Constructor
    Ticket(String ticketId, String seatNumber) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
    }


}
