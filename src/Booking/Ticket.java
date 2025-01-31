package Booking;

import java.time.LocalDateTime;

import Flight.FlightManagement;

public class Ticket {
    private String ticketId;
    private FlightManagement flight;
    private Passenger passenger;
    private String seatNumber;
    private LocalDateTime bookingDateTime;
    private String ticketStatus;
    private PricingSystem pricingSystem;

    // Constructor
    public Ticket(String ticketId, FlightManagement flight, Passenger passenger, String seatNumber, LocalDateTime bookingDateTime, String ticketStatus, PricingSystem pricingSystem) {
        this.ticketId = ticketId;
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.bookingDateTime = bookingDateTime;
        this.ticketStatus = ticketStatus;
        this.pricingSystem = pricingSystem;

    }

    // Getter and Setter methods
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public FlightManagement getFlight() {
        // source,destination,etc
        return flight;
    }

    public void setFlight(FlightManagement flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }


}
