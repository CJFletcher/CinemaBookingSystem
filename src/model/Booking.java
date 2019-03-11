package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


public class Booking implements ClassWithID, Serializable {
    private Showing showing;
    private Theater theater;
    private ArrayList<Ticket> tickets;

    static final AtomicLong NEXT_ID = new AtomicLong(5000);
    final long id = NEXT_ID.getAndIncrement();

    public Booking() {
    }

    public Booking(Showing showing, Theater theater, ArrayList<Ticket> tickets) {
        this.showing = showing;
        this.theater = theater;
        this.tickets = tickets;
    }

    public Showing getShowing() {
        return showing;
    }

    public Theater getTheater() {
        return theater;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
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
