package org.Cab_Booking;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RideBookingSystem system = new RideBookingSystem();

        // 1️⃣ Register user
        system.register(1, "Junaid", "junaid@gmail.com", "1234");

        // 2️⃣ Login user
        boolean loggedIn = system.login(1, "1234");
        System.out.println("Login status: " + loggedIn);

        //create ride
        system.createRide("Delhi", "Agra", 4, 4, 500, 1);

//
//        // 3️⃣ Update password
//        system.updateUser(1, "newpass");
//
//        // 4️⃣ Login again with new password
//        system.login(1, "newpass");
//
//        // 5️⃣ Delete account
//        system.deleteAccount(1);

    }
}
