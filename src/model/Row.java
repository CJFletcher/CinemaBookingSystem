package model;

import java.util.ArrayList;

public class Row {

    private ArrayList<Seat> seats;
    private char rowLetter;
    private int numberOfSeats;

    public Row (int numberOfSeats, char rowLetter)
    {
        this.rowLetter = rowLetter;
        this.numberOfSeats = numberOfSeats;
        seats = new ArrayList<Seat>();
        createSeats(this.numberOfSeats);
    }

    public char getRowLetter()
    {
        return rowLetter;
    }

    public void createSeats(int seatCount)
    {
        for (int i = 1; i <= seatCount; i++)
        {
            seats.add(new Seat(false, i));
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
