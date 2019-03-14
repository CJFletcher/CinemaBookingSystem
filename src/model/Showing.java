package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Showing implements Comparable<Showing>, Serializable{

    private Film film;
    private LocalDateTime showingTimeDate;
    private Theater theater;
    private ArrayList<Row> rows;
    private int availableSeats;


    public Showing(Film film, LocalDateTime showingTimeDate,Theater theater) {
        this.film = film;
        this.showingTimeDate = showingTimeDate;
        this.theater = theater;
        this.rows = loadRows();
        this.availableSeats = getAvailableSeats();
    }

    public LocalDateTime getShowingTimeDate() {
        return showingTimeDate;
    }

    public LocalDate getShowingDate() {
        return showingTimeDate.toLocalDate();
    }

    public String getShowingDateFormatted(){
        String day = showingTimeDate.getDayOfWeek().toString().toLowerCase();
        String dayOfMonth = String.valueOf(showingTimeDate.getDayOfMonth());
        String month = String.valueOf(showingTimeDate.getMonthValue());
        String year = String.valueOf(showingTimeDate.getYear());

        String capDay = day.substring(0, 1).toUpperCase() + day.substring(1);

        if (dayOfMonth.length()==1){
            dayOfMonth="0"+dayOfMonth;
        }

        if (month.length()==1){
            month="0"+month;
        }

        return capDay + "\n" + dayOfMonth +"/" + month + "/" + year;
    }

    public String getShowingTimeFormatted(){
        String hour = String.valueOf(showingTimeDate.getHour());
        String minutes = String.valueOf(showingTimeDate.getMinute());
        if (minutes.equals("0")){
            minutes="00";
        }

        return hour + ":" + minutes;
    }

    public void setShowingTimeDate(LocalDateTime showingTimeDate) {
        this.showingTimeDate = showingTimeDate;
    }

    public int getAvailableSeats()
    {
        int availableSeats = 0;
        for (Row row : rows)
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

    public int getScreenNumber()
    {
        return theater.getTheaterNumber();
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

    public ArrayList<Row> loadRows() {
        return theater.getRows();
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public Row getRowByCharacter(String rowChar){
        for (Row row: rows) {
            if (row.getRowLetter().toLowerCase().equals(rowChar.toLowerCase())){
                return row;
            }
        }
        return null;
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

