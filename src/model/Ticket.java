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
        double price = this.calculateTicketPrice();
        super(price);
    }

    public double calculateTicketPrice(){
        String x = showing.getFilm().getYear();
        Year y = Year.parse(x);
        int yearDiff = Year.now().compareTo(y);
        if (yearDiff < 0){
            return 0;
        }
        if (yearDiff > 0 && yearDiff <= 3){
            return 10.0;
        }
        if (yearDiff > 4 && yearDiff <= 6){
            return 8.0;
        }
        if (yearDiff > 7 && yearDiff <= 10){
            return 6.0;
        }
        else{
            return 4.0;
        }
    }

    @Override
    public long getId() {
        int ret = (int) id;
        return ret;
    }
}
