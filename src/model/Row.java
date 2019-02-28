package model;

import java.util.ArrayList;

public class Row {

    private ArrayList<Seat> seats;
    private int rowNumber;
    private int numberOfSeats;

    public Row (int numberOfSeats, int rowNumber)
    {
        this.rowNumber = rowNumber;
        this.numberOfSeats = numberOfSeats;
        seats = new ArrayList<Seat>();
        createSeats(this.numberOfSeats);
    }

    public int getRowNumber()
    {
        return rowNumber;
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
        return "Row"+rowNumber+
                seats +
                '}';
    }
}
