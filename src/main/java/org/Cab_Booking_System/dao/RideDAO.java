package org.Cab_Booking_System.dao;

import org.Cab_Booking_System.model.Ride;
import org.Cab_Booking_System.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RideDAO {
    private Connection connection = DBConnection.getConnection();

    public void createRide(Ride ride) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO rides (destination, source, total_seats, available_seats, fare, user_id) VALUES (?, ?, ?, ?, ?, ?)"
        );
        ps.setString(1, ride.getDestination());
        ps.setString(2, ride.getSource());
        ps.setInt(3, ride.getTotal_seat());
        ps.setInt(4, ride.getAvailable_seats());
        ps.setDouble(5, ride.getFare());
        ps.setInt(6, ride.getUser_id());
        ps.executeUpdate();
    }

    public List<Ride> getAllRides() throws SQLException {
        List<Ride> rides = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM rides");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            rides.add(mapRide(rs));
        }
        return rides;
    }

    public List<Ride> searchRide(String source, String destination) throws SQLException {
        List<Ride> rides = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM rides WHERE source = ? AND destination = ? AND available_seats > 0"
        );
        ps.setString(1, source);
        ps.setString(2, destination);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            rides.add(mapRide(rs));
        }
        return rides;
    }

    public int updateRide(Ride ride) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "UPDATE rides SET source = ?, destination = ?, fare = ? WHERE ride_id = ? AND user_id = ?"
        );
        ps.setString(1, ride.getSource());
        ps.setString(2, ride.getDestination());
        ps.setDouble(3, ride.getFare());
        ps.setInt(4, ride.getRide_id());
        ps.setInt(5, ride.getUser_id()); // ownership check

        return ps.executeUpdate();
    }

    public int deleteRide(int rideId, int userId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM rides WHERE ride_id = ? AND user_id = ?"
        );
        ps.setInt(1, rideId);
        ps.setInt(2, userId);

        return ps.executeUpdate();
    }

    public List<Ride> getRidesByUser(int userId) throws SQLException {
        List<Ride> rides = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM rides WHERE user_id = ?"
        );
        ps.setInt(1, userId);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            rides.add(mapRide(rs));
        }
        return rides;
    }

    private Ride mapRide(ResultSet rs) throws SQLException {
        return new Ride(
                rs.getInt("ride_id"),
                rs.getString("source"),
                rs.getString("destination"),
                rs.getInt("total_seats"),
                rs.getInt("available_seats"),
                rs.getDouble("fare"),
                rs.getInt("user_id")
        );
    }
}
