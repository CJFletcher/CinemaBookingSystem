package model;

import java.util.Currency;
import java.util.concurrent.atomic.AtomicLong;

public class Ticket extends BuyableItem {
    private Booking booking;

    static final AtomicLong NEXT_ID = new AtomicLong(1000);
    final long id = NEXT_ID.getAndIncrement();

    public Ticket(Currency price, Booking booking) {
        super(price);
        this.booking = booking;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public long getId() {
        int ret = (int) id;
        return ret;
    }
}
