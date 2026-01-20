package org.Cab_Booking;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RideBookingSystem rideBookingSystem = new RideBookingSystem();
        rideBookingSystem.createRide("delhi", "jaipur",5, 2, 300 ,new User("1",2,"3"));
        rideBookingSystem.createRide("delhi", "jaipur",5, 0, 300,new User("2",3,"4"));



        System.out.println(rideBookingSystem.showAllRide());

    }
}