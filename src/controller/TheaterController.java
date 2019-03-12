package controller;

import model.Theater;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TheaterController implements Serializable{


    private ArrayList<Theater> theaters = new ArrayList<>();
    private final static String DATAFILEPATH = "./src/data/theatres.dat";

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

    public void saveTheaters() throws IOException, ClassNotFoundException {
        FileOutputStream out = new FileOutputStream(DATAFILEPATH);
        ObjectOutputStream objout = new ObjectOutputStream(out);
        objout.writeObject(theaters);
        objout.flush();
        objout.close();
    }

    public void loadTheaters() throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(DATAFILEPATH);
        ObjectInputStream objin = new ObjectInputStream(in);
        ArrayList<Theater> newObj = (ArrayList<Theater>) objin.readObject();
        this.theaters = newObj;
        objin.close();
    }

        @Override
        public String toString () {
            return "Theaters:\n" + theaters;

        }
}