package Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Flight {
    String flightId;
    String flightNumber;
    String source;
    String destination;
    LocalDate departureDate;
    LocalTime departureTime;
    LocalDate arrivalDate;
    LocalTime arrivalTime;
    int totalSeats;
    int availableSeats;
    double baseFare;
    List<Seat> seatMap;
    
}
