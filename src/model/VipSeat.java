package model;

public class VipSeat extends Seat{

    public static final double priceModifier = 1.25;

    public VipSeat() {
    }

    public VipSeat(Boolean isBooked, int seatNumber, String rowLetter) {
        super(isBooked, seatNumber, rowLetter);
    }

    public double getPriceModifier() {
        return priceModifier;
    }

    @Override
    public String toString() {
        return "VIP - Row: " + getRowLetter() + " Seat: " + getSeatNumber();
    }
}
