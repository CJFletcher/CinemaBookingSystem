package model;

import java.util.concurrent.atomic.AtomicLong;

public class Booking implements ClassWithID{
    private Showing showing;
    private Theater theater;
    private Seat seat;

    static final AtomicLong NEXT_ID = new AtomicLong(5000);
    final long id = NEXT_ID.getAndIncrement();

    public Booking() {
    }

    public Booking(Showing showing, Theater theater, Seat seat) {
        this.showing = showing;
        this.theater = theater;
        this.seat = seat;
    }

    public Showing getShowing() {
        return showing;
    }

    public Theater getTheater() {
        return theater;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public static void main(String[] args) {
        Booking test = new Booking();
        Booking test2 = new Booking();
        System.out.println(test.getId());
        System.out.println(test2.getId());
    }

    @Override
    public long getId() {
        int ret = (int) id;
        return ret;
    }
}
