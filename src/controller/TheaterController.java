package controller;

import model.Theater;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TheaterController {


    private ArrayList<Theater> theaters = new ArrayList<>();

    public void addTheater(Theater theater) {
        this.theaters.add(theater);
    }

    public void removeTheater(Theater theater) {
        this.theaters.remove(theater);
    }

    public ArrayList<Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(ArrayList<Theater> theaters) {
        this.theaters = theaters;
    }

    public Theater getTheaterByNumber(int theaterNumber){
        for (Theater theater: theaters
             ) {if(theater.getTheaterNumber()==theaterNumber){}
            return theater;
        }
        throw new NoSuchElementException("Theater with that number does not exist in this array.");
    }

    public void loadTheaters() throws IOException {
        for (int i=1;i<=10;i++) {
            Theater t = new Theater(i);
            this.addTheater(t);
            t.createRows(10,5,false);
            t.createRows(5,2,true);
        }
    }

        @Override
        public String toString () {
            return "Theaters:\n" + theaters;

        }
}