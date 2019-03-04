package model;


import java.util.ArrayList;

public class Screen {

    private int screenNumber;
    private int numberOfRows;

    private ArrayList<Row> rows;

    public Screen(int theatreNumber) {
        this.screenNumber = theatreNumber;
        rows = new ArrayList<Row>();
    }

    public void createRows(int numberOfSeats, int numberOfRows, boolean isVip) {
        for (int i = 1; i <= numberOfRows; i++) {
            char x = (char) (i + 64 + this.numberOfRows);
            if (!isVip) {
                rows.add(new Row(numberOfSeats, x, isVip));
            }
            else {
                rows.add(new Row(numberOfSeats,x,isVip));
            }
        }
        this.numberOfRows += numberOfRows;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    @Override
    public String toString() {
        String ret = "";
        for (Row rows : this.rows) {
            ret += "\n" + rows;
        }
        return "Screen Number: " + screenNumber + ret;
    }
}
