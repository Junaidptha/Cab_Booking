package org.Cab_Booking_System.Main;

import org.Cab_Booking_System.Controller.BookingController;
import org.Cab_Booking_System.Controller.RideController;
import org.Cab_Booking_System.Controller.UserController;

import org.Cab_Booking_System.model.User;
import org.Cab_Booking_System.model.Ride;
import org.Cab_Booking_System.model.Booking;

import java.util.List;
import java.util.Scanner;

public class Cab_Booking_System {

    static Scanner sc = new Scanner(System.in);

    static UserController userController = new UserController();
    static RideController rideController = new RideController();
    static BookingController bookingController = new BookingController();

    static int loggedInUserId = -1;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n====== CAB BOOKING SYSTEM ======");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Thank you for using Cab Booking System!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // ================= USER =================

    static void register() {
        System.out.print("User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Phone: ");
        long phone = sc.nextLong();
        sc.nextLine();

        System.out.print("Licence No: ");
        String licNo = sc.nextLine();

        System.out.print("Licence Expiry: ");
        String licExp = sc.nextLine();

        User user = new User(id, name, email, password, phone, licNo, licExp);
        userController.registerUser(user);
    }

    static void login() {
        System.out.print("User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        boolean success = userController.loginUser(id, password);
        if (success) {
            loggedInUserId = id;
            userMenu();
        }
    }

    // ================= AFTER LOGIN =================

    static void userMenu() {
        while (true) {
            System.out.println("\n====== USER MENU ======");
            System.out.println("1. Create Ride");
            System.out.println("2. View All Rides");
            System.out.println("3. Book Ride");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Logout");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createRide();
                case 2 -> viewAllRides();
                case 3 -> bookRide();
                case 4 -> cancelBooking();
                case 5 -> {
                    loggedInUserId = -1;
                    System.out.println("Logged out successfully");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    // ================= RIDE =================

    static void createRide() {
        sc.nextLine();
        System.out.print("Source: ");
        String source = sc.nextLine();

        System.out.print("Destination: ");
        String destination = sc.nextLine();

        System.out.print("Total Seats: ");
        int totalSeats = sc.nextInt();

        System.out.print("Available Seats: ");
        int availableSeats = sc.nextInt();

        System.out.print("Fare per seat: ");
        double fare = sc.nextDouble();

        Ride ride = new Ride(
                0,
                source,
                destination,
                totalSeats,
                availableSeats,
                fare,
                loggedInUserId
        );

        rideController.createRide(ride);
    }

    static void viewAllRides() {
        List<Ride> rides = rideController.getAllRides();
        System.out.println("\n====== AVAILABLE RIDES ======");
        for (Ride ride : rides) {
            System.out.println(ride);
        }
    }

    // ================= BOOKING =================

    static void bookRide() {
        System.out.print("Enter Ride ID: ");
        int rideId = sc.nextInt();

        System.out.print("Seats to book: ");
        int seats = sc.nextInt();

        System.out.print("Booking ID: ");
        int bookingId = sc.nextInt();

        Booking booking = new Booking(
                bookingId,
                rideId,
                loggedInUserId,
                seats,
                0.0   // calculated in service
        );

        bookingController.bookRide(booking);
    }

    static void cancelBooking() {
        System.out.print("Enter Booking ID to cancel: ");
        int bookingId = sc.nextInt();
        bookingController.cancelBooking(bookingId);
    }
}
