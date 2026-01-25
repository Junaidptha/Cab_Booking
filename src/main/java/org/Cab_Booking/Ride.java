package org.Cab_Booking;




public class Ride {
    private int ride_id;
    private String source;
    private String destination;
    private int total_seat;
    private int available_seats;
    private double fare;
    private int user_id;


    public Ride(int ride_id, String source, String destination, int total_seat, int available_seats, double fare, int user_id) {
        this.ride_id = ride_id;
        this.source = source;
        this.destination = destination;
        this.total_seat = total_seat;
        this.available_seats = available_seats;
        this.fare = fare;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "ride_id=" + ride_id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", total_seat=" + total_seat +
                ", available_seats=" + available_seats +
                ", fare=" + fare +
                ", user_id=" + user_id +
                '}';
    }

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotal_seat() {
        return total_seat;
    }

    public void setTotal_seat(int total_seat) {
        this.total_seat = total_seat;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
