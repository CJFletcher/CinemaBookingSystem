package controller;

import model.Booking;

import java.io.Serializable;
import java.util.ArrayList;

public class BookingController implements Serializable {
    private ArrayList<Booking> bookings = new ArrayList<>();

    public BookingController() {
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public void removeBooking(Booking booking) {
        this.bookings.remove(booking);
    }

    public void loadBookings() {
    }
}
