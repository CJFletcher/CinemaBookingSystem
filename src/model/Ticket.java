package model;

import java.io.Serializable;
import java.time.Year;
import java.util.concurrent.atomic.AtomicLong;

public class Ticket extends BuyableItem implements ClassWithID, Serializable {
    private Showing showing;
    private Seat seat;

    static final AtomicLong NEXT_ID = new AtomicLong(1000);
    final long id = NEXT_ID.getAndIncrement();

    public Ticket(Showing showing, Seat seat) {
        this.showing = showing;
        this.seat = seat;
        this.setPrice(applyVipModifier(calculateTicketPrice()));
    }

    public double applyVipModifier(double price){
        if (seat.getClass().equals(VipSeat.class)){
            return VipSeat.priceModifier * price;
        }
        return price;
    }

    public Showing getShowing() {
        return showing;
    }

    public Seat getSeat() {
        return seat;
    }

    public double calculateTicketPrice(){
        String x = showing.getFilm().getYear();
        Year y = Year.parse(x);
        int yearDiff = Year.now().compareTo(y);
        if (yearDiff < 0){
            return 0;
        }
        if (0 <= yearDiff && yearDiff <= 3){
            return 6;
        }
        if (4 <= yearDiff && yearDiff <= 7){
            return 4.5;
        }
        if (8 <= yearDiff && yearDiff <= 12){
            return 3;
        }
        else{
            return 2;
        }
    }

    @Override
    public long getId() {
        int ret = (int) id;
        return ret;
    }

    @Override
    public String toString() {
        return showing.getFilm().getTitle() +": "+showing.getShowingDateFormatted(false) +" " +
                showing.getShowingTimeFormatted()+ " - " + seat + " - " + getPriceFormatted();
    }
}
