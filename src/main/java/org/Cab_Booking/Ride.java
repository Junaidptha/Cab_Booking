package org.Cab_Booking;




public class Ride {
    private String source;
    private String destination;
    private int total_seat;
    private int available_seats;
    private double fare;
    private User user;


    public Ride(String destination, String source, int total_seat, double fare, int available_seats , User user) {
        this.destination = destination;
        this.source = source;
        this.total_seat = total_seat;
        this.fare = fare;
        this.available_seats = available_seats;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", total_seat=" + total_seat +
                ", available_seats=" + available_seats +
                ", fare=" + fare +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
