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
            char x = (char)(i+64);
            rows.add(new Row(numberOfSeats, x));
        }
        this.numberOfRows += numberOfRows;
    }

    @Override
    public String toString() {
        return "Screen Number=" + screenNumber +
                "{" + rows +
                '}';
    }
}
