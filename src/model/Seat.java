package model;


import java.io.Serializable;

public class Seat implements Serializable {
    private Boolean isBooked;
    private int seatNumber;
    private String rowLetter;

    public Seat() {
    }

    public Seat(Boolean isBooked, int seatNumber, String rowLetter) {
        this.isBooked = isBooked;
        this.seatNumber = seatNumber;
        this.rowLetter = rowLetter;
    }


    public Boolean getBookingStatus() {
        return isBooked;
    }

    public void setBookingStatus(Boolean booked) {
        isBooked = booked;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRowLetter() {
        return rowLetter;
    }

    @Override
    public String toString() {
        return "Row: " + rowLetter +
                " Seat: " + seatNumber;
    }
}
