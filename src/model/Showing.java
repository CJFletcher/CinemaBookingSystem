package model;

import java.util.ArrayList;

public class Showing {

    private Film film;
    private String showingDate;
    private Screen screen;
    private int availableSeats;
    private ArrayList<Seat> seats;


    public Showing(Film film, String showingDate, Screen screen)
    {
        this.film = film;
        this.showingDate = showingDate;
        this.screen = screen;
        seats = new ArrayList<Seat>();
        loadSeats();
    }

    public void loadSeats() {
        for (Row rows : this.screen.getRows()) {
            for (Seat seats: rows.getSeats()) {
                this.seats.add(seats);
            }
        }
    }

    public int getAvailableSeats()
    {
        availableSeats=0;
        for (Seat seat : seats)
        {
            if (!seat.getBookingStatus())
            {
                availableSeats++;
            }
        }
        return availableSeats;
    }

    public int getAvailableVipSeats()
    {
        availableSeats=0;
        for (Seat seat : seats)
        {
            if (!seat.getBookingStatus())
            {
                if(seat.getClass()==VipSeat.class) {
                    availableSeats++;
                }
            }
        }
        return availableSeats;
    }

    public void setFilm(Film film)
    {
        this.film = film;
    }

    public void setShowingDate(String showingDate)
    {
        this.showingDate = showingDate;
    }

    public void setScreen(Screen screen)
    {
        this.screen = screen;
    }

    public Film getFilm()
    {
        return film;
    }

    public String getShowDate()
    {
        return showingDate;
    }

    public String getScreenNumber()
    {
        return "Screen: " + screen.getScreenNumber();
    }

    public Screen getScreen() {
        return screen;
    }

    public ArrayList<Seat> getSeats()
    {
        return seats;
    }
}
