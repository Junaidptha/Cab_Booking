package org.Cab_Booking_System.service;

import org.Cab_Booking_System.dao.RideDAO;
import org.Cab_Booking_System.model.Ride;

import java.util.List;

public class RideService {
    private final RideDAO rideDao = new RideDAO();

    public void createRide(Ride ride) {
        try {
            rideDao.createRide(ride);
            System.out.println("Ride created successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ride> getAllRides() {
        try {
            return rideDao.getAllRides();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ride> searchRide(String source, String destination) {
        try {
            return rideDao.searchRide(source, destination);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRide(Ride ride) {
        try {
            int row = rideDao.updateRide(ride);
            if (row > 0) {
                System.out.println("Ride updated successfully");
            } else {
                System.out.println("Ride not found or you are not owner");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRide(int rideId, int userId) {
        try {
            int row = rideDao.deleteRide(rideId, userId);
            if (row > 0) {
                System.out.println("Ride deleted successfully");
            } else {
                System.out.println("Ride not found or you are not owner");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ride> getUserCreatedRides(int userId) {
        try {
            return rideDao.getRidesByUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
