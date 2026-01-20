package org.Cab_Booking;

public class Booking {
    private int  booking_id;
    private Ride ride;
    private User user;
    private int total_seats;
    private Double Total_fare;

    public Booking(int booking_id, Ride ride, User user, int total_seats, Double total_fare) {
        this.booking_id = booking_id;
        this.ride = ride;
        this.user = user;
        this.total_seats = total_seats;
        Total_fare = total_fare;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", ride=" + ride +
                ", user=" + user +
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

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
