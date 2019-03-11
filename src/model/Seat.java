package model;


import java.io.Serializable;

public class Seat implements Serializable {
    private Boolean isBooked;
    private int seatNumber;

    public Seat(Boolean isBooked, int seatNumber) {
        this.isBooked = isBooked;
        this.seatNumber = seatNumber;
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

    @Override
    public String toString() {
        return "Seat " + seatNumber +
                ", isBooked=" + isBooked;
    }
}
