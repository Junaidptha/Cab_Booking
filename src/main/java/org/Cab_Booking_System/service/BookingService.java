package org.Cab_Booking_System.service;

import org.Cab_Booking_System.dao.BookingDAO;
import org.Cab_Booking_System.model.Booking;
import org.Cab_Booking_System.utils.DBConnection;

import java.sql.*;

public class BookingService {
    private final BookingDAO bookingDao = new BookingDAO();

    // TRANSACTIONAL BOOKING
    public void bookRide(Booking booking) {
        Connection connection = DBConnection.getConnection();

        try {
            connection.setAutoCommit(false); // 🔥 Start transaction

            ResultSet rs = bookingDao.getRideForUpdate(booking.getRide_id());
            if (!rs.next()) {
                System.out.println("Ride not found");
                connection.rollback();
                return;
            }

            int availableSeats = rs.getInt("available_seats");
            double fare = rs.getDouble("fare");

            if (availableSeats < booking.getTotal_seats()) {
                System.out.println("Not enough seats available");
                connection.rollback();
                return;
            }

            double totalFare = fare * booking.getTotal_seats();
            booking.setTotal_fare(totalFare);

            bookingDao.insertBooking(booking);
            bookingDao.updateAvailableSeats(
                    booking.getRide_id(),
                    booking.getTotal_seats()
            );

            connection.commit(); // ✅ Commit

            System.out.println("Ride booked successfully. Total Fare = " + totalFare);

        } catch (Exception e) {
            try {
                connection.rollback(); // ❌ Rollback on error
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // TRANSACTIONAL DELETE BOOKING
    public void cancelBooking(int bookingId) {
        Connection connection = DBConnection.getConnection();

        try {
            connection.setAutoCommit(false);

            ResultSet rs = bookingDao.getBookingById(bookingId);
            if (!rs.next()) {
                System.out.println("Booking not found");
                connection.rollback();
                return;
            }

            int rideId = rs.getInt("ride_id");
            int seats = rs.getInt("total_seats");

            bookingDao.addBackSeats(rideId, seats);
            bookingDao.deleteBooking(bookingId);

            connection.commit();
            System.out.println("Booking cancelled and seats restored");

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
