package controller;

import model.BuyableItem;
import model.Theater;
import model.Showing;
import model.Ticket;


import java.util.List;

import static controller.FilmController.newFilm;
import static controller.TextFileScanner.*;
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
        films.loadFilms();
        System.out.println("Loading films from txt file.\n");
        System.out.println("Adding film by Title: 'Star Wars'");
        films.addFilm(newFilm("Star Wars",null));
        System.out.println("Adding film by Title: 'Star Wars' & Year: '2017'");
        films.addFilm(newFilm("Star Wars","2017"));
        System.out.println("Adding film by ID tt1323594");
        films.addFilm(newFilm("tt1323594"));
        System.out.println("Printing all Films:");
        films.printFilms();
        System.out.println();

        System.out.println("Printing all films that contain Star Wars in the Title");
        System.out.println(films.filterFilmsByTitle("Star Wars"));
        System.out.println();

        System.out.println("Printing all films that contain Despicable in the Title");
        System.out.println(films.filterFilmsByTitle("Despicable"));
        System.out.println();

        System.out.println("Getting Ratings for Despicable Me:");
        System.out.println(films.getFilmByTitle("Despicable Me").getRatings());

        System.out.println("Printing all films with PLOKIJ in the Title");
        System.out.println(films.filterFilmsByTitle("PLOKIJ"));
        System.out.println();


        Theater one = new Theater(1);
        one.createRows(8,5,false);
        one.createRows(3,2,true);
        System.out.println(one);

        Theater two = new Theater(2);
        two.createRows(3,1,false);
        two.createRows(5,1,true);

        System.out.println(two);

        Showing a = new Showing(films.getFilmByTitle("Despicable Me"),of(2019,5,5,13,00),one);
        Showing b = new Showing(films.getFilmByTitle("Despicable Me"),of(2019,3,4,13,30),one);
        Showing c = new Showing(films.getFilmByTitle("Despicable Me"),of(2019,3,4,13,00),two);

        ShowingController showings = new ShowingController();
        showings.addShowing(a);
        showings.addShowing(b);
        showings.addShowing(c);
        showings.printShowings();
        showings.sortShowings();

        showings.printShowings();
        showings.removeOldShowings();
        showings.printShowings();



        TheaterController theaters = new TheaterController();
        System.out.println(theaters);
        //showings.saveToTxtFile();
        ShowingController showings1 = new ShowingController();
        showings1.saveToTxtFile();

        films.saveFilmsToTxt();
        System.out.println(showings.getShowings());
        showings.saveToTxtFile();

        Ticket oneT = new Ticket();
        Ticket twoT = new Ticket();
        System.out.println(oneT.getId());
        System.out.println(twoT.getId());
        }
    }