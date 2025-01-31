package Booking;

public class Seat {
    String seatNumber;
    boolean isBooked;
    String classType;
    double fareAdjustment;

    // Constructor
    public Seat(String seatNumber, String classType) {
        this.seatNumber = seatNumber;
        this.classType = classType;
        this.isBooked = false; // Initially not booked
        this.fareAdjustment = 0.0; // Default adjustment
    }

    // Method to book the seat
    public boolean bookSeat() {

        return false;  // Seat already booked
    }

    // Method to cancel the seat booking
    public boolean cancelBooking() {

        return false;  // Seat was not booked
    }

    // Method to adjust the fare based on seat class or other factors
    public void adjustFare(double adjustment) {
        this.fareAdjustment += adjustment;
        // discounted
        // extra charges
        // dynamic pricing
        /*
         * Example Pricing:

        Economy Class: $10–$50 extra for window seats.
        Business Class: Already premium, but window seats may still be more desirable.
         */
    }

    // Method to check the booking status of the seat
    public boolean isSeatBooked() {
        return isBooked;
    }

    // Method to show the class type of the seat
    public String ClassType() {
        return classType;
    }

    // Method to calculate the final fare for the seat (base fare + adjustments)
    public double FinalFare(double baseFare) {
        return baseFare + fareAdjustment;
    }

    // Method to generate a seat summary
    public String generateSeatSummary() {
        return "Seat Number: " + seatNumber + "\n" +
               "Class Type: " + classType + "\n" +
               "Booked: " + (isBooked ? "Yes" : "No") + "\n" +
               "Fare Adjustment: " + fareAdjustment;
    }
}
