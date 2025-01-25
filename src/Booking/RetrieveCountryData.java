package Booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class RetrieveCountryData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/country";
        String user = "root";
        String pass = "12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from longlat");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("countryname") + ". " + resultSet.getFloat(2) + " " + resultSet.getFloat(3));
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
