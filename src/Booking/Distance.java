package Booking;
import java.sql.*;


public class Distance {
    public static void main(String[] args) {
        double distance = getDistance("Thailand","Cambodia");
    }
    public static double getDistance(String country1, String country2){
        double[] longLat = Distance.getLongLat(country1);
        double[] longLat1 = Distance.getLongLat(country2);

        if(longLat != null && longLat1 != null){
        int distance = (int) calculateDistance(longLat[0],longLat[1],longLat1[0],longLat1[1]);
            System.out.println("Distance between " + country1 + " and " + country2 + " is " + distance + " KM");
            return(distance);

        }
        return -1;
    }
    public static double[] getLongLat(String countryName) {
        String url = "jdbc:mysql://192.168.0.103:3306/country";  // Use the server's public IP address
        String user = "root";
        String pass = "12345";
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the MySQL database
            try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                String query = "SELECT latitude, longitude FROM longlat WHERE countryname = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                    // Set the country name parameter
                    preparedStatement.setString(1, countryName);

                    // Execute the query
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        // Return latitude and longitude as a double array
                        return new double[] {
                                resultSet.getDouble("latitude"),
                                resultSet.getDouble("longitude")
                        };
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null; // Return null if no result is found or an error occurs
    }

    // Method to calculate the distance using the Haversine formula
        public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
            // Radius of the Earth in kilometers
            final double R = 6371;

            // Convert latitude and longitude from degrees to radians
            double lat1Rad = Math.toRadians(lat1);
            double lon1Rad = Math.toRadians(lon1);
            double lat2Rad = Math.toRadians(lat2);
            double lon2Rad = Math.toRadians(lon2);

            // Differences in coordinates
            double dLat = lat2Rad - lat1Rad;
            double dLon = lon2Rad - lon1Rad;

            // Haversine formula
            double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                    + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                    * Math.sin(dLon / 2) * Math.sin(dLon / 2);

            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            // Booking.Distance in kilometers
            double distance = R * c;

            return distance;
        }

}


