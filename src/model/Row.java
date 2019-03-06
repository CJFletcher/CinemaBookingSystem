package model;

import java.util.ArrayList;

public class Row {

    private ArrayList<Seat> seats;
    private char rowLetter;
    private int numberOfSeats;
    private boolean isVip;

    public Row (int numberOfSeats, char rowLetter, boolean isVip)
    {
        this.rowLetter = rowLetter;
        this.numberOfSeats = numberOfSeats;
        this.isVip = isVip;
        seats = new ArrayList<>();
        createSeats(this.numberOfSeats,isVip);
    }

    public char getRowLetter()
    {
        return rowLetter;
    }

    public boolean isVip() {
        return isVip;
    }

    public void createSeats(int numberOfSeats,boolean isVip) {
        for (int i = 1; i <= numberOfSeats; i++) {
            if (!isVip) {
                seats.add(new Seat(false, i));
            }
            else {seats.add(new VipSeat(false,i));
            }
        }
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
