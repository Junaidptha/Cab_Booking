package org.Cab_Booking_System.model;

public class Booking {
    private int  booking_id;
    private int ride_id;
    private int user_id;
    private int total_seats;
    private Double Total_fare;

    public Booking(int booking_id, int ride_id, int user_id, int total_seats, Double total_fare) {
        this.booking_id = booking_id;
        this.ride_id = ride_id;
        this.user_id = user_id;
        this.total_seats = total_seats;
        Total_fare = total_fare;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", ride_id=" + ride_id +
                ", user_id=" + user_id +
                ", total_seats=" + total_seats +
                ", Total_fare=" + Total_fare +
                '}';
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public Double getTotal_fare() {
        return Total_fare;
    }

    public void setTotal_fare(Double total_fare) {
        Total_fare = total_fare;
    }
}
