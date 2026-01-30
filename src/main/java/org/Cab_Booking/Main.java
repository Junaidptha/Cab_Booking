package org.Cab_Booking;

import java.util.List;
import java.util.Scanner;

public class Main {

    static RideBookingSystem system = new RideBookingSystem();
    static Scanner sc = new Scanner(System.in);
    static int loggedInUserId = -1;

    public static void main(String[] args) {

        while (true) {
            if (loggedInUserId == -1) {
                showAuthMenu();
            } else {
                showUserMenu();
            }
        }
    }

    // ================= AUTH MENU =================
    private static void showAuthMenu() {
        System.out.println("\n===== CAB BOOKING SYSTEM =====");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> register();
            case 2 -> login();
            case 3 -> {
                System.out.println("Goodbye 👋");
                System.exit(0);
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    // ================= USER MENU =================
    private static void showUserMenu() {
        System.out.println("\n===== USER DASHBOARD =====");
        System.out.println("1. Create Ride");
        System.out.println("2. Show All Rides");
        System.out.println("3. Search Ride");
        System.out.println("4. Book Ride");
        System.out.println("5. My Bookings");
        System.out.println("6. My Created Rides");
        System.out.println("7. Logout");
        System.out.print("Choose option: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> createRide();
            case 2 -> showAllRides();
            case 3 -> searchRide();
            case 4 -> bookRide();
            case 5 -> myBookings();
            case 6 -> myCreatedRides();
            case 7 -> logout();
            default -> System.out.println("Invalid choice!");
        }
    }

    // ================= AUTH FUNCTIONS =================
    private static void register() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        System.out.print("Enter Phone: ");
        long phone = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter licence number: ");
        String licence_no = sc.nextLine();

        System.out.print("Enter licence_exp: ");
        String licence_exp = sc.nextLine();





        User user = new User(id, name, email, pass, phone, licence_no, licence_exp);
        system.register(user);
    }


    private static void login() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (system.login(id, pass)) {
            loggedInUserId = id;
            System.out.println("Login successful ✅");
        } else {
            System.out.println("Login failed ❌");
        }
    }

    private static void logout() {
        loggedInUserId = -1;
        System.out.println("Logged out successfully");
    }

    // ================= RIDE FUNCTIONS =================
    private static void createRide() {
        System.out.print("Source: ");
        String source = sc.nextLine();

        System.out.print("Destination: ");
        String dest = sc.nextLine();

        System.out.print("Total Seats: ");
        int seats = sc.nextInt();

        System.out.print("Fare: ");
        double fare = sc.nextDouble();

        system.createRide(dest, source, seats, seats, fare, loggedInUserId);
    }

    private static void showAllRides() {
        List<Ride> rides = system.showAllRides();
        rides.forEach(System.out::println);
    }

    private static void searchRide() {
        System.out.print("Source: ");
        String source = sc.nextLine();

        System.out.print("Destination: ");
        String dest = sc.nextLine();

        List<Ride> rides = system.searchRide(source, dest);
        rides.forEach(System.out::println);
    }

    private static void bookRide() {
        System.out.print("Enter Ride ID: ");
        int rideId = sc.nextInt();

        System.out.print("Seats to book: ");
        int seats = sc.nextInt();

        int bookingId = (int) (Math.random() * 10000);
        double totalFare = 0; // calculated in DB

        Booking booking = new Booking(bookingId, rideId, loggedInUserId, seats, totalFare);
        system.bookRide(booking);
    }

    private static void myBookings() {
        List<Booking> bookings = system.getUserBookedRide(loggedInUserId);
        bookings.forEach(System.out::println);
    }

    private static void myCreatedRides() {
        List<Ride> rides = system.getUserCratedRide(loggedInUserId);
        rides.forEach(System.out::println);
    }
}
