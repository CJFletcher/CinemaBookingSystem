package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Showing implements Comparable<Showing>{

    private Film film;
    private LocalDateTime showingTimeDate;
    private Screen screen;


    public Showing(Film film, LocalDateTime showingTimeDate, Screen screen) {
        this.film = film;
        this.showingTimeDate = showingTimeDate;
        this.screen = screen;
    }

    public Showing(LocalDateTime showingTimeDate, Screen screen) {
        this.film = null;
        this.showingTimeDate = showingTimeDate;
        this.screen = screen;
    }

    public LocalDateTime getShowingTimeDate() {
        return showingTimeDate;
    }

    public LocalDate getShowingDate() {
        return showingTimeDate.toLocalDate();
    }

    public void setShowingTimeDate(LocalDateTime showingTimeDate) {
        this.showingTimeDate = showingTimeDate;
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

    public void setScreen(Screen screen)
    {
        this.screen = screen;
    }

    public Film getFilm()
    {
        return film;
    }

    public String getScreenNumber()
    {
        return "Screen: " + screen.getScreenNumber();
    }

    public Screen getScreen() {
        return screen;
    }

    public Boolean isOld(){
        if (this.getShowingDate().isBefore(LocalDate.now())){
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Showing: " +
                "film=" + film.getTitle() +
                ", showing Time & Date=" + showingTimeDate +
                ", screen=" + screen.getScreenNumber() +
                '}';
    }

    @Override
    public int compareTo(Showing otherShowing) {
        LocalDateTime x = this.showingTimeDate;
        LocalDateTime y = otherShowing.showingTimeDate;
        int i = (x.getYear() - y.getYear());
        if (i == 0) {
            i = (x.getMonthValue() - y.getMonthValue());
            if (i == 0) {
                i = (x.getDayOfMonth() - y.getDayOfMonth());
                if (i == 0) {
                    i = x.getHour() - y.getHour();
                    if (i == 0){
                        i = x.getMinute() - y.getMinute();
                    }
                }
            }
        }
        return i;
    }
}

