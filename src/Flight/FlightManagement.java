package Flight;
public class FlightManagement {
    private int flightID;
    private String source;
    private String destination;
    private int distance;
    private String departureTime;
    private String arrivalTime;
    private double base_Price;
    private int availableSeats;
    private int capacity;

    FlightManagement(int flightID,String source, String destination )
    {
        this.flightID = flightID;

    };
}
