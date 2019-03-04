package controller;

import model.Employee;
import model.Film;
import model.Screen;
import model.Showing;

import java.io.IOException;

import static controller.FilmController.newFilm;
import static controller.HelperClass.isEmailAddressValid;

public class Test {

    public static void main(String[] args) throws IOException {

        //Employee bob = new Employee("Bob","Dylan","bob@dylan.com");

        //if (isEmailAddressValid(bob.getEmailAddress())) {
        //    System.out.println(bob.getEmailAddress() + " is a valid email address");
        //} else {
        //    System.out.println(bob.getEmailAddress() + " is not a valid email address");
        //}

        FilmController films = new FilmController();

        //films.addFilm(newFilm("Star Wars","2015"));
        //films.addFilm(newFilm("Star Wars","2017"));
        films.addFilm(newFilm("Despicable Me",null));
        films.printFilms();
        System.out.println();


        films.filterFilmsByTitle("Star Wars");
        System.out.println();

        films.filterFilmsByTitle("Despicable");

        films.filterFilmsByTitle("Not in titles");

        Screen one = new Screen(1);
        one.createRows(8,5,false);
        one.createRows(3,2,true);
        System.out.println(one);

        Screen two = new Screen(2);
        two.createRows(3,1,false);
        two.createRows(5,1,true);

        System.out.println(two);

        Showing x = new Showing(films.getFilmByName("Despicable Me"),"21/08/19",two);
        System.out.println(x.getAvailableSeats());
        System.out.println(x.getAvailableVipSeats());
    }
}