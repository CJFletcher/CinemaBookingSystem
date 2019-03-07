package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Showing implements Comparable<Showing>{

    private Film film;
    private LocalDateTime showingTimeDate;
    private Theater theater;
    private int availableSeats;


    public Showing(Film film, LocalDateTime showingTimeDate, Theater theater) {
        this.film = film;
        this.showingTimeDate = showingTimeDate;
        this.theater = theater;
        this.availableSeats = getAvailableSeats();
    }

    public Showing(LocalDateTime showingTimeDate, Theater theater) {
        this.film = null;
        this.showingTimeDate = showingTimeDate;
        this.theater = theater;
        this.availableSeats = getAvailableSeats();
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
        for (Row row : this.theater.getRows())
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
        for (Row row : this.theater.getRows())
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

    public void setTheater(Theater theater)
    {
        this.theater = theater;
    }

    public Film getFilm()
    {
        return film;
    }

    public String getScreenNumber()
    {
        return "Theater: " + theater.getTheaterNumber();
    }

    public Theater getTheater() {
        return theater;
    }

    public Boolean isOld(){
        if (this.getShowingDate().isBefore(LocalDate.now())){
            return true;
        }
        else return false;
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

    @Override
    public String toString() {
        return "Showing{" +
                "film=" + film.getTitle() +
                ", showingTimeDate=" + showingTimeDate +
                ", theater=" + theater.getTheaterNumber() +
                ", availableSeats=" + availableSeats +
                '}';
    }
}

