package controller;

import model.*;


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
//        System.out.println("Loading films from txt file.\n");
//        System.out.println("Adding film by Title: 'Star Wars'");
//        films.addFilm(newFilm("Star Wars",null));
//        System.out.println("Adding film by Title: 'Star Wars' & Year: '2017'");
//        films.addFilm(newFilm("Star Wars","2017"));
//        System.out.println("Adding film by ID tt1323594");
//        films.addFilm(newFilm("tt1323594"));
//        System.out.println("Printing all Films:");
//        films.printFilms();
//        System.out.println();
//
//        System.out.println("Printing all films that contain Star Wars in the Title");
//        System.out.println(films.filterFilmsByTitle("Star Wars"));
//        System.out.println();
//
//        System.out.println("Printing all films that contain Despicable in the Title");
//        System.out.println(films.filterFilmsByTitle("Despicable"));
//        System.out.println();
//
//        System.out.println("Getting Ratings for Despicable Me:");
//        System.out.println(films.getFilmByTitle("Despicable Me").getRatings());
//
//        System.out.println("Printing all films with PLOKIJ in the Title");
//        System.out.println(films.filterFilmsByTitle("PLOKIJ"));
//        System.out.println();
        TheaterController theaters = new TheaterController();



        Theater one = new Theater(1);
        one.createRows(8,5,false);
        one.createRows(8,2,true);


        Theater two = new Theater(2);
        two.createRows(5,5,false);
        two.createRows(5,2,true);


        Theater three = new Theater(3);
        three.createRows(6,5,false);
        three.createRows(6,2,true);


        Theater four = new Theater(4);
        four.createRows(6,4,false);
        four.createRows(6,2,true);
        four.createRows(6,2,false);


        Theater five = new Theater(5);
        five.createRows(10,5,false);
        five.createRows(10,2,true);
        five.createRows(10,4,false);


        Theater six = new Theater(6);
        six.createRows(5,5,false);
        six.createRows(5,2,true);


        Theater seven = new Theater(7);
        seven.createRows(6,5,false);
        seven.createRows(6,2,true);


        Theater eight = new Theater(8);
        eight.createRows(10,5,false);
        eight.createRows(10,2,true);
        eight.createRows(10,3,false);


        Theater nine = new Theater(9);
        nine.createRows(6,6,false);
        nine.createRows(6,2,true);


        Theater ten = new Theater(10);
        ten.createRows(10,4,false);
        ten.createRows(10,2,true);
        ten.createRows(8,2,false);


        theaters.addTheater(one);
        theaters.addTheater(two);
        theaters.addTheater(three);
        theaters.addTheater(four);
        theaters.addTheater(five);
        theaters.addTheater(six);
        theaters.addTheater(seven);
        theaters.addTheater(eight);
        theaters.addTheater(nine);
        theaters.addTheater(ten);
//      System.out.println(theaters);



        Showing a = new Showing(films.getFilmById("tt0499549"),of(2019,3,23,13,0),one);
        Showing b = new Showing(films.getFilmById("tt0499549"),of(2019,3,30,13,0),one);
        Showing c = new Showing(films.getFilmById("tt1323594"),of(2019,3,23,15,30),two);
        Showing d = new Showing(films.getFilmById("tt1323594"),of(2019,3,30,15,30),two);
        Showing e = new Showing(films.getFilmById("tt0076759"),of(2019,3,23,16,15),three);
        Showing f = new Showing(films.getFilmById("tt0076759"),of(2019,3,30,16,15),three);
        Showing g = new Showing(films.getFilmById("tt0109830"),of(2019,3,23,13,0),four);
        Showing h = new Showing(films.getFilmById("tt0109830"),of(2019,3,30,13,0),four);
        Showing i = new Showing(films.getFilmById("tt0137523"),of(2019,3,23,13,0),five);
        Showing j = new Showing(films.getFilmById("tt0137523"),of(2019,3,30,13,0),five);
        Showing k = new Showing(films.getFilmById("tt0133093"),of(2019,3,23,13,0),six);
        Showing l = new Showing(films.getFilmById("tt0133093"),of(2019,3,30,13,0),six);
        Showing m = new Showing(films.getFilmById("tt0120815"),of(2019,3,23,15,30),seven);
        Showing n = new Showing(films.getFilmById("tt0120815"),of(2019,3,30,15,30),seven);
        Showing o = new Showing(films.getFilmById("tt4154756"),of(2019,3,23,16,15),eight);
        Showing p = new Showing(films.getFilmById("tt4154756"),of(2019,3,30,16,15),eight);
        Showing q = new Showing(films.getFilmById("tt0090605"),of(2019,3,23,13,0),nine);
        Showing r = new Showing(films.getFilmById("tt0090605"),of(2019,3,30,13,0),nine);
        Showing s = new Showing(films.getFilmById("tt2380307"),of(2019,3,23,13,0),ten);
        Showing t = new Showing(films.getFilmById("tt2380307"),of(2019,3,30,13,0),ten);

        ShowingController showings = new ShowingController();
        showings.addShowing(a);
        showings.addShowing(b);
        showings.addShowing(c);
        showings.addShowing(d);
        showings.addShowing(e);
        showings.addShowing(f);
        showings.addShowing(g);
        showings.addShowing(h);
        showings.addShowing(i);
        showings.addShowing(j);
        showings.addShowing(k);
        showings.addShowing(l);
        showings.addShowing(m);
        showings.addShowing(n);
        showings.addShowing(o);
        showings.addShowing(p);
        showings.addShowing(q);
        showings.addShowing(r);
        showings.addShowing(s);
        showings.addShowing(t);


        showings.printShowings();
        showings.sortShowings();

        showings.printShowings();
        System.out.println(showings.getShowingByNumber(1));
//      showings.removeOldShowings();
//      showings.printShowings();
//      System.out.println(a.getRows());



//      showings.saveToTxtFile();

        films.saveFilmsToTxt();
//      System.out.println(showings.getShowings());

        Ticket t1 = new Ticket(a,a.getRowByCharacter("C").getSeatByNumber(1));
        Ticket t2 = new Ticket(a,a.getRowByCharacter("C").getSeatByNumber(2));


        BookingController bookings = new BookingController();
        bookings.saveBookings();
        showings.saveShowings();
        theaters.saveTheaters();
        showings.saveShowings();
//        Booking b1 = new Booking();
//        bookings.addBooking(b1);
//        b1.addTicket(t1);
//        b1.addTicket(t2);
//        System.out.println(bookings);
//        bookings.saveObjectsToFile();
        }
    }