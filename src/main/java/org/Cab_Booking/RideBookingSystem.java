package org.Cab_Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RideBookingSystem {

    Connection connection;
    ResultSet resultSet;
//    Statement statement;
    PreparedStatement preparedStatement;
    public RideBookingSystem(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cab_booking_db", "cab_admin","cab123");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void register(int userId, String userName, String userEmail, String password) {
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT 1 FROM users WHERE user_id = ? OR email = ?"
            );
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, userEmail);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("User already exists");
                return;
            }

            preparedStatement = connection.prepareStatement("INSERT INTO users (user_id, name, email, password) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, userEmail);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
            System.out.println("User registered successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(int userId, String password) {
        try {
            preparedStatement = connection.prepareStatement("select * FROM users WHERE user_id = ? AND password = ?");
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("Login successfully");
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
    public void updateUser(int userId, String password) {
        try {
            preparedStatement  = connection.prepareStatement("update users SET password = ? where userId = ?");
            preparedStatement.setInt(1,userId);
            preparedStatement.setString(2, password);

            int row = preparedStatement.executeUpdate(); /* return type int(values are
                                                                            1	            One row updated
                                                                            0	            No row matched
                                                                            >1	            Multiple rows affected
                                                          */
            if(row  > 0){
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Student not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(int userId) {
        try {
            preparedStatement = connection.prepareStatement("delete from users where user_id = ?");
            preparedStatement.setInt(1,userId);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("User deleted successfully");
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createRide( String destination,
                            String source,
                            int total_seats,
                            int available_seats,
                            double fare,
                            int userId) {
        try {
            preparedStatement = connection.prepareStatement("insert into  rides (destination, source, total_seats, available_seats, fare, user_id) values(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, destination);
            preparedStatement.setString(2,source);
            preparedStatement.setInt(3,total_seats);
            preparedStatement.setInt(4,available_seats);
            preparedStatement.setDouble(5, fare);
            preparedStatement.setInt(6,userId);

            preparedStatement.executeUpdate();

            System.out.println("Ride create successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Ride> showAllRides() {
        List<Ride> rides = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement("select * from rides");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Ride ride = new Ride(
                        resultSet.getInt("ride_id"),
                        resultSet.getString("destination"),
                        resultSet.getString("source"),
                        resultSet.getInt("total_seats"),
                        resultSet.getInt("available_seats"),
                        resultSet.getDouble("fare"),
                        resultSet.getInt("user_id")
                );
                rides.add(ride);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rides;
    }


    public List<Ride> searchRide(String source,String destination){
        List<Ride> rides = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement("select * from rides where source = ? AND destination = ? AND available_seats > 0");
            preparedStatement.setString(1, source);
            preparedStatement.setString(2, destination);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Ride ride = new Ride(
                        resultSet.getInt("ride_id"),
                        resultSet.getString("destination"),
                        resultSet.getString("source"),
                        resultSet.getInt("total_seats"),
                        resultSet.getInt("available_seats"),
                        resultSet.getDouble("fare"),
                        resultSet.getInt("user_id")
                );
                rides.add(ride);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rides;
    }

    public void updateRide(int ride_id,
                           String source,
                           String destination,
                           double fear){
        try{
            preparedStatement = connection.prepareStatement("update rides set source = ? , destination = ?, fear = ? where ride_id = ?");
            preparedStatement.setString(1, source);
            preparedStatement.setString(2,destination);
            preparedStatement.setDouble(3,fear);
            preparedStatement.setInt(4,ride_id);

            int row = preparedStatement.executeUpdate();
            if(row > 0){
                System.out.println("Ride update");
            }else{
                System.out.println("Not Found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRide(int ride_id){
        try{
            preparedStatement= connection.prepareStatement("delete from rides where ride_id = ?");
            preparedStatement.setInt(1, ride_id);

            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Ride deleted");
            } else {
                System.out.println("Ride not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public void bookRide(int ride_id,
//                         String source,
//                         String destination,
//                         int total_seats,
//                         double fear){
//        try{
//            preparedStatement = connection.prepareStatement("sel")
//        }
//
//    }

//
//    public List<Booking> getUserBookedRide(User user){
//        //list user booked ride
//        List<Booking> result = new ArrayList<>();
//        for(Booking booking: bookingList){
//            if(booking.getUser().equals(user)){
//                result.add(booking);
//            }
//        }
//
//        System.out.println("Ride Not Found");
//        return null;
//    }
//
//    public Ride getUserCratedRide(User user){
//        //list user created ride
//        for(Ride ride: rideList){
//            if(ride.getUser().equals(user)) return ride;
//        }
//        System.out.println("Ride Not Fount");
//        return  null;
//    }
//
//    public void deleteBooking(int bookingId ){
//        for( Booking booking : bookingList){
//            if(booking.getBooking_id() == bookingId){
//                booking.getRide().setAvailable_seats( booking.getRide().getAvailable_seats() + booking.getTotal_seats());
//                bookingList.remove(booking);
//                System.out.println("Booking deleted");
//                return;
//            }
//        }
//    }
//
//
//


}
