package Booking;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Distance {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter country 1: ");
        String country1 = input.nextLine();
        System.out.printf("Enter country 2: ");
        String country2 = input.nextLine();
        double distance = getDistance(country1, country2);

        if (distance != -1) {
            System.out.printf("Distance between %s and %s is %.2f kilometers.\n", country1, country2, distance);
        } else {
            System.out.println("Could not find the coordinates for one or both countries.");
        }
    }

    public static double getDistance(String country1, String country2) {
        double[] longLat = getLongLat(country1);
        double[] longLat1 = getLongLat(country2);

        if (longLat != null && longLat1 != null) {
            return calculateDistance(longLat[0], longLat[1], longLat1[0], longLat1[1]);
        }
        return -1;
    }
    public static double[] getLongLat(String countryName) {
        // Path to your countries.json file
        String filePath = "src/country.json";

        try {
            // Create an ObjectMapper to parse the JSON file
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file into a JsonNode (a tree structure)
            JsonNode countriesNode = objectMapper.readTree(new File(filePath));

            // Iterate through each country in the JSON
            for (JsonNode countryNode : countriesNode) {
                String name = countryNode.get("country_name").asText();
                if (name.equalsIgnoreCase(countryName)) {
                    double latitude = countryNode.get("latitude").asDouble();
                    double longitude = countryNode.get("longitude").asDouble();
                    return new double[]{latitude, longitude};
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the JSON file: " + e.getMessage());
        }

        return null; // Return null if the country is not found or there is an error
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

        // Distance in kilometers
        return R * c;
    }
}
