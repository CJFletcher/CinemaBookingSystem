package controller;

import model.Showing;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ShowingController {

    private ArrayList<Showing> showings;

    public ShowingController ()
    {
        showings = new ArrayList<Showing>();
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
                    System.out.println(i);
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

    @Override
    public String toString() {
        return "ShowingController{" +
                "showings=" + showings +
                '}';
    }
}
