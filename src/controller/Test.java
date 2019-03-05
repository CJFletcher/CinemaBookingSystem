package controller;

import model.Screen;
import model.Showing;


import static controller.TextFileScanner.txtToArray;
import static controller.FilmController.newFilm;
import static java.time.LocalDateTime.of;

public class Test {

    public static void main(String[] args) throws Exception {

        //Employee bob = new Employee("Bob","Dylan","bob@dylan.com");

        //if (isEmailAddressValid(bob.getEmailAddress())) {
        //    System.out.println(bob.getEmailAddress() + " is a valid email address");
        //} else {
        //    System.out.println(bob.getEmailAddress() + " is not a valid email address");
        //}

        FilmController films = new FilmController();

        films.addFilm(newFilm("Star Wars",null));
        films.addFilm(newFilm("Star Wars","2017"));
        films.addFilm(newFilm("tt1323594"));
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

        Showing a = new Showing(films.getFilmByName("Despicable Me"),of(2019,3,5,13,00),one);
        Showing b = new Showing(films.getFilmByName("Despicable Me"),of(2019,3,4,13,30),one);
        Showing c = new Showing(films.getFilmByName("Despicable Me"),of(2019,3,4,13,00),two);

        ShowingController showings = new ShowingController();
        showings.addShowing(a);
        showings.addShowing(b);
        showings.addShowing(c);
        showings.printShowings();
        showings.sortShowings();

        showings.printShowings();
        showings.removeOldShowings();
        showings.printShowings();

        System.out.println(films.getFilmByName("Despicable Me").getRatings());
        System.out.println(txtToArray("./src/txt/films.txt"));

        films.loadFilms();
        }

    }