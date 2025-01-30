package Booking;

import java.time.LocalDateTime;

import Flight.Flight;

public class Ticket {
    String ticketId;
    Flight flight;
    Passenger passenger;
    String seatNumber;
    LocalDateTime bookingDateTime;
    String ticketStatus;
    double totalFare;

    Ticket(String ticketId, String seatnumber )
    {
        this.ticketId = ticketId;
        this.seatNumber = seatnumber;
    };
}
