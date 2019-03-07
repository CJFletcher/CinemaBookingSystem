package model;

public class Booking extends ClassWithID{
    private Showing showing;
    private Theater theater;
    private Seat seat;

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
}
