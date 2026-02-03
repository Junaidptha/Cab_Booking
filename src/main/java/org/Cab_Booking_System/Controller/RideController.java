package org.Cab_Booking_System.Controller;

import org.Cab_Booking_System.dao.RideDAO;
import org.Cab_Booking_System.model.Ride;
import org.Cab_Booking_System.service.RideService;

import java.util.List;

public class RideController {
    private final RideService rideService = new RideService();

    public void createRide(Ride ride) {
        rideService.createRide(ride);
    }

    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    public List<Ride> searchRide(String source, String destination) {
        return rideService.searchRide(source, destination);
    }

    public void updateRide(Ride ride) {
        rideService.updateRide(ride);
    }

    public void deleteRide(int rideId, int userId) {
        rideService.deleteRide(rideId, userId);
    }

    public List<Ride> getUserCreatedRides(int userId) {
        return rideService.getUserCreatedRides(userId);
    }
}
