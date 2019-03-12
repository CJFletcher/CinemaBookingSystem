package controller;

import model.Booking;

import java.io.*;
import java.util.ArrayList;

public class BookingController implements Serializable {

    private final static String DATAFILEPATH = "./src/data/bookings.dat";
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

    public void saveBookings() throws IOException, ClassNotFoundException {
        FileOutputStream out = new FileOutputStream(DATAFILEPATH);
        ObjectOutputStream objout = new ObjectOutputStream(out);
        objout.writeObject(bookings);
        objout.flush();
        objout.close();
    }

    public void loadBookings() throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(DATAFILEPATH);
        ObjectInputStream objin = new ObjectInputStream(in);
        ArrayList<Booking> newObj = (ArrayList<Booking>) objin.readObject();
        this.bookings = newObj;
        objin.close();
    }

    @Override
    public String toString() {
        return "BookingController{" +
                "bookings=" + bookings +
                '}';
    }
}
