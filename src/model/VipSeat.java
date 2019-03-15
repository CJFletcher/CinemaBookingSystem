package model;

public class VipSeat extends Seat{

    final double priceModifier = 25.0;

    public VipSeat(Boolean isBooked, int seatNumber, String rowLetter) {
        super(isBooked, seatNumber, rowLetter);
    }

    public double getPriceModifier() {
        return priceModifier;
    }

    @Override
    public String toString() {
        return "VipSeat" + getSeatNumber() +", isBooked="+ getBookingStatus();
    }
}
