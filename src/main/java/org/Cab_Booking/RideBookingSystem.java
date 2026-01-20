package org.Cab_Booking;

import java.util.ArrayList;
import java.util.List;

public class RideBookingSystem {
    List<Ride> rideList = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    List<Booking> bookingList = new ArrayList<>();



    public void register(int userId, String userEmail, String password) {
        User user = new User(userEmail, userId, password);
        userList.add(user);
        System.out.println("User registered successfully");
    }

    public boolean login(String userEmail, String password) {
        for (User user : userList) {
            if (user.getUserEmail().equals(userEmail)
                    && user.getPassword().equals(password)) {
                System.out.println("Login successful");
                return true;
            }
        }
        System.out.println("Invalid credentials");
        return false;
    }
    public void updateUser(int userId, String newEmail) {
        for (User user : userList) {
            if (user.getUser_id() == userId) {
                user.setUserEmail(newEmail);
                System.out.println("User updated");
                return;
            }
        }
    }

    public void deleteAccount(int userId) {
        userList.removeIf(user -> user.getUser_id() == userId);
        System.out.println("User deleted");
    }

    public void createRide( String destination,
                            String source,
                            int total_seat,
                            int available_seats,
                            double fare,
                            User user){
        Ride ride = new Ride(destination, source, total_seat, fare, available_seats, user);
        rideList.add(ride);
    }
    public List<Ride> showAllRide(){
        return rideList;
    }

    public List<Ride> searchRide(String source,String destination){
        List<Ride> result = new ArrayList<>();
        for(Ride ride: rideList){
            if(ride.getSource().equals(source) && ride.getDestination().equals(destination)&& ride.getAvailable_seats() > 0){
                result.add(ride);
            }
        }
        return result;
    }


    public void bookRide(Ride ride,
                         User user,
                         int total_seats,
                         Double Total_fare){
        //search ride - check no of seats;
        //Avatiable - book
        if(ride.getAvailable_seats() - total_seats >= 0){
            ride.setAvailable_seats(ride.getAvailable_seats() - total_seats);
            Booking booking = new Booking(
                    bookingList.size() + 1,
                    ride,
                    user,
                    total_seats,
                    Total_fare
                    );
            bookingList.add(booking);
        }
        else{
            System.out.println("Seat Not Available");
        }
    }

    public List<Booking> getUserBookedRide(User user){
        //list user booked ride
        List<Booking> result = new ArrayList<>();
        for(Booking booking: bookingList){
            if(booking.getUser().equals(user)){
                result.add(booking);
            }
        }

        System.out.println("Ride Not Found");
        return null;
    }

    public Ride getUserCratedRide(User user){
        //list user created ride
        for(Ride ride: rideList){
            if(ride.getUser().equals(user)) return ride;
        }
        System.out.println("Ride Not Fount");
        return  null;
    }

    public void deleteBooking(int bookingId ){
        for( Booking booking : bookingList){
            if(booking.getBooking_id() == bookingId){
                booking.getRide().setAvailable_seats( booking.getRide().getAvailable_seats() + booking.getTotal_seats());
                bookingList.remove(booking);
                System.out.println("Booking deleted");
                return;
            }
        }
    }

    public void updateRide(Ride ride,
                           String newSource,
                           String newDestination,
                           Integer newTotalSeats,
                           Integer newAvailableSeats,
                           Double newFare){

        if (newSource != null && !newSource.isEmpty()) {
            ride.setSource(newSource);
        }
        if (newDestination != null && !newDestination.isEmpty()) {
            ride.setDestination(newDestination);
        }
        if (newFare != null) {
            if (newFare <= 0) {
                System.out.println("Invalid fare");
                return;
            }
            ride.setFare(newFare);
        }

    }

    public void deleteRide(Ride ride){
        rideList.remove(ride);
        System.out.println("Ride deleted");
    }

}
