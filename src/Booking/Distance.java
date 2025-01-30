package Booking;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Distance {


    public static double[] getLongLat(String countryName) {
        //function to get longtitude and latitude of country

    }


    // Method to calculate the distance using the Haversine formula
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // haversine formula to calculate distance between two points (source and destination)
        // use the result to calculate price


        // Radius of the Earth in kilometers
        final double R = 6371;

        // Convert latitude and longitude from degrees to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);
        /* The trigonometric functions in most programming languages (like Math.sin(), Math.cos(), and Math.atan2() in Java) expect their input to be in radians, not degrees. */

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
