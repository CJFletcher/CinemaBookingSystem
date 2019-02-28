package model;


import java.util.ArrayList;

public class Screen {

    private int screenNumber;
    private int numberOfRows;
    private ArrayList<Row> rows;

    public Screen (int theatreNumber)
    {
        this.screenNumber = theatreNumber;
        rows = new ArrayList<Row>();
    }

    public void createRows(int numberOfSeats, int numberOfRows)
    {
        for (int i = 1; i <= numberOfRows; i++)
        {
            rows.add(new Row(numberOfSeats, i));
        }
        this.numberOfRows += numberOfRows;
    }

    @Override
    public String toString() {
        return "Screen Number=" + screenNumber +
                "{, rows=" + rows +
                '}';
    }
}
