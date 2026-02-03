package org.Cab_Booking_System.Controller;

import org.Cab_Booking_System.model.Booking;
import org.Cab_Booking_System.service.BookingService;

public class BookingController {
    private final BookingService bookingService = new BookingService();

    public void bookRide(Booking booking) {
        bookingService.bookRide(booking);
    }

    public void cancelBooking(int bookingId) {
        bookingService.cancelBooking(bookingId);
    }
}
