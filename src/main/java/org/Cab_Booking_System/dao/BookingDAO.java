package org.Cab_Booking_System.dao;

import org.Cab_Booking_System.model.Booking;
import org.Cab_Booking_System.utils.DBConnection;

import java.sql.*;

public class BookingDAO {
    private Connection connection = DBConnection.getConnection();

    // Get ride info for booking
    public ResultSet getRideForUpdate(int rideId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT available_seats, fare FROM rides WHERE ride_id = ? FOR UPDATE"
        );
        ps.setInt(1, rideId);
        return ps.executeQuery();
    }

    public void insertBooking(Booking booking) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO bookings (booking_id, ride_id, user_id, total_seats, total_fare) VALUES (?, ?, ?, ?, ?)"
        );

        ps.setInt(1, booking.getBooking_id());
        ps.setInt(2, booking.getRide_id());
        ps.setInt(3, booking.getUser_id());
        ps.setInt(4, booking.getTotal_seats());
        ps.setDouble(5, booking.getTotal_fare());

        ps.executeUpdate();
    }

    public void updateAvailableSeats(int rideId, int seatsToReduce) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "UPDATE rides SET available_seats = available_seats - ? WHERE ride_id = ?"
        );
        ps.setInt(1, seatsToReduce);
        ps.setInt(2, rideId);
        ps.executeUpdate();
    }

    public ResultSet getBookingById(int bookingId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "SELECT ride_id, total_seats FROM bookings WHERE booking_id = ?"
        );
        ps.setInt(1, bookingId);
        return ps.executeQuery();
    }

    public void deleteBooking(int bookingId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM bookings WHERE booking_id = ?"
        );
        ps.setInt(1, bookingId);
        ps.executeUpdate();
    }

    public void addBackSeats(int rideId, int seats) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(
                "UPDATE rides SET available_seats = available_seats + ? WHERE ride_id = ?"
        );
        ps.setInt(1, seats);
        ps.setInt(2, rideId);
        ps.executeUpdate();
    }
}
