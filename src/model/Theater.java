package model;


import java.io.Serializable;
import java.util.ArrayList;

public class Theater implements Serializable {

    private int theaterNumber;
    private int numberOfRows;
    private ArrayList<Row> rows = new ArrayList<Row>();

    public Theater(int theatreNumber) {
        this.theaterNumber = theatreNumber;
    }

    public ArrayList<Row> createRows(int numberOfSeats, int numberOfRows, boolean isVip) {
        for (int i = 1; i <= numberOfRows; i++) {
            char y = (char) (i + 64 + this.numberOfRows);
            String x = Character.toString(y);
            if (!isVip) {
                rows.add(new Row(numberOfSeats, x,isVip));
            }
            else {
                rows.add(new Row(numberOfSeats,x,isVip));
            }
        }
        this.numberOfRows += numberOfRows;
        return rows;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public int getTheaterNumber() {
        return theaterNumber;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void printTheater() { String ret = "";
        for (Row rows : this.rows) {
            ret += "\n" + rows;
        }
        System.out.println("Theater Number: " + theaterNumber + ret + "\n");
    }


    @Override
    public String toString() {
        return "Theater{" +
                "theaterNumber=" + theaterNumber +
                ", numberOfRows=" + numberOfRows +
                ", rows=" + rows +
                '}';
    }
}
