package Booking;

import java.util.List;

public class Passenger {
    String passengerId;
    String firstName;
    String lastName;
    String email;
    String contactNumber;
    String passportNumber;
    List<Ticket> tickets;  // List of tickets associated with the passenger

    // Constructor
    public Passenger(String passengerId, String firstName, String lastName,
                     String email, String contactNumber, String passportNumber) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.passportNumber = passportNumber;
    }

    // Add a ticket to the passenger's list of tickets
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    // Cancel a ticket from the passenger's list
    public boolean cancelTicket(Ticket ticket) {
        return this.tickets.remove(ticket);
    }

    // Retrieve a list of all the passenger's tickets
    public List<Ticket> getTickets() {
        return this.tickets;
    }


    // Check if the passenger has a valid ticket (could be based on some conditions)
    public boolean hasValidTicket() {
        return this.tickets != null && !this.tickets.isEmpty();
    }

    // Get the passenger's full name


  /*  // Generate a passenger summary (could be used in booking summaries or reports)
    public String generatePassengerSummary() {
        return "Passenger ID: " + this.passengerId + "\n" +
               "Name: " + this.FullName() + "\n" +
               "Email: " + this.email + "\n" +
               "Contact: " + this.contactNumber;
    } */


}
