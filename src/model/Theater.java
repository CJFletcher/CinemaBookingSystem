package model;

import java.io.*;
import java.util.ArrayList;

public class Theater implements Serializable {

    private int theaterNumber;
    private int numberOfRows;
    private ArrayList<Row> rows = new ArrayList<Row>();

    public Theater(int theatreNumber) {
        this.theaterNumber = theatreNumber;
    }

    //https://www.javadevjournal.com/java/java-deep-copy/
    public static Theater deepClone(Theater originalTheatre){
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(originalTheatre);
            ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            return (Theater) objectInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Row> createRows(int numberOfSeats, int numberOfRows, boolean isVip) {
        ArrayList<Row> rowArrayList = new ArrayList<Row>();
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
