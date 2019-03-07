package model;

public class Ticket extends BuyableItem {
    private Booking booking;

    public Ticket() {
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
