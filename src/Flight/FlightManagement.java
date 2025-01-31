
public class FlightManagement {
    private String flightID;
    private double distance;
    private double base_Price;
    private int availableSeats;
    private int capacity;

    public FlightManagement(String flightID,String source, String destination, double distance, double base_Price, int availableSeats, int capacity )
    {
        this.flightID = flightID;
        this.distance = distance;
        this.base_Price = base_Price;
        this.availableSeats = availableSeats;
        this.capacity = capacity;
    }

    public String getFlightId(){
        return flightID;
    }
    public double finalDistance(){
        return distance;
    }
    public boolean AvailableSeat(){
        return true;
    }
}


