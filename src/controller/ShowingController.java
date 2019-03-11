package controller;

import model.Showing;
import model.Theater;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.apache.commons.io.FileUtils.writeLines;

public class ShowingController implements Serializable {

    private ArrayList<Showing> showings = new ArrayList<>();
    private static String TXTFILEPATH = "./src/data/showings.txt";

    public ShowingController (){
    }

    public void addShowing(Showing showing) {
        this.showings.add(showing);
    }

    public void removeFilm(Showing showing) {
        this.showings.remove(showing);
    }

    public ArrayList<Showing> getShowings()
    {
        return showings;
    }

    public ArrayList<Showing> filterShowingsByDate () {
        ArrayList<Showing> ret = new ArrayList<Showing>();
        if (this.showings.isEmpty()) {
            System.out.println("No films in this collection.");
        } else {
            for (Showing i : showings)
                if (i.getShowingDate()==(LocalDate.now())) {
                    ret.add(i);
                }
            }
        return ret;
    }

    public void printShowings() {
        if (this.showings.isEmpty()) {
            System.out.println("No showings in this list.");
            System.out.println();
        } else {
            System.out.println("Showings:");
            for (Showing i : showings) {
                System.out.println(i);
            }
            System.out.println("\n");
        }
    }

    public Showing getShowingByNumber(int theaterNumber){
        for (Showing showing: showings
                ) {if(showing.getScreenNumber()==theaterNumber){
                    return showing;
        }
        }
        throw new NoSuchElementException("Theater with that number does not exist in this array.");
    }

    public void removeOldShowings() {
        Iterator<Showing> i = showings.iterator();
        while (i.hasNext()) {
            Showing s = i.next();
            if (s.isOld()) {
                i.remove();
            }
        }
    }

    public void sortShowings() {
        Collections.sort(this.showings);
    }

    public void loadShowings() {
       // ArrayList<String> showingsToLoad = new List<String>;

    }

    public void saveToTxtFile() throws IOException {
        File f = new File(TXTFILEPATH);
        writeLines(f,showings);
    }



    @Override
    public String toString() {
        return "ShowingController{" +
                "showings=" + showings +
                '}';
    }
}
