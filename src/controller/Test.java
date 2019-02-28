package controller;

import model.Employee;
import model.Screen;

import java.io.IOException;

import static controller.FilmController.newFilm;
import static controller.HelperClass.isEmailAddressValid;

public class Test {

    public static void main(String[] args) throws IOException {

        Employee bob = new Employee("Bob","Dylan","bob@dylan.com");

        if (isEmailAddressValid(bob.getEmailAddress())) {
            System.out.println(bob.getEmailAddress() + " is a valid email address");
        } else {
            System.out.println(bob.getEmailAddress() + " is not a valid email address");
        }

        FilmController films = new FilmController();

        films.addFilm(newFilm("Star Wars","2015"));
        films.addFilm(newFilm("Star Wars","2017"));
        films.addFilm(newFilm("Despicable Me",null));
        films.printFilms();
        System.out.println();


        films.filterFilmsByTitle("Star Wars");
        System.out.println();

        films.filterFilmsByTitle("Despicable");

        films.filterFilmsByTitle("Not in titles");

        Screen one = new Screen(1);
        one.createRows(5,3);
        System.out.println(one);


    }
}