package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Row implements Serializable {

    private ArrayList<Seat> seats;
    private String rowLetter;
    private int numberOfSeats;
    private boolean isVip;


    public Row (int numberOfSeats, String rowLetter, boolean isVip)
    {
        this.rowLetter = rowLetter;
        this.numberOfSeats = numberOfSeats;
        this.isVip = isVip;
        seats = new ArrayList<>();
        createSeats(this.numberOfSeats,isVip);
    }

    public String getRowLetter()
    {
        return rowLetter;
    }

    public boolean isVip() {
        return isVip;
    }

    public void createSeats(int numberOfSeats,boolean isVip) {
        for (int i = 1; i <= numberOfSeats; i++) {
            if (!isVip) {
                seats.add(new Seat(false, i,rowLetter));
            }
            else {seats.add(new VipSeat(false,i,rowLetter));
            }
        }
    }

    public Seat getSeatByNumber(int seatNumber) throws NoSuchElementException {
        for (Seat seat:seats) {
            if (seat.getSeatNumber()==seatNumber && seat.getBookingStatus().equals(false)){
                return seat;
            }
        }
        throw new NoSuchElementException("Seat is either booked or does not exist");
    }

    public ArrayList<Seat> getSeats()
    {
        return seats;
    }

    @Override
    public String toString() {
        return "Row "+rowLetter+
                seats;
    }
}
