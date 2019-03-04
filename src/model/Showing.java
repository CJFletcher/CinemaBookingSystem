package model;

public class Showing {

    private Film film;
    private String showingDate;
    private Screen screen;


    public Showing(Film film, String showingDate, Screen screen)
    {
        this.film = film;
        this.showingDate = showingDate;
        this.screen = screen;
    }

    public int getAvailableSeats()
    {
        int availableSeats = 0;
        for (Row row : this.screen.getRows())
        {
            for (Seat seat : row.getSeats()){
            if (!seat.getBookingStatus())
                {
                availableSeats++;
                }
            }
        }
        return availableSeats;
    }

    public int getAvailableVipSeats()
    {
        int availableSeats=0;
        for (Row row : this.screen.getRows())
        {
            for (Seat seat : row.getSeats()){
                if (!seat.getBookingStatus() && seat.getClass()==VipSeat.class)
                {
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
}
