package data;

import controller.*;
import model.*;

import static controller.FilmController.newFilm;
import static java.time.LocalDateTime.of;

public class LoadTestData {

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

        Showing a = new Showing(films.getFilmById("tt0499549"),of(2019,3,30,13,0),one);
        Showing c = new Showing(films.getFilmById("tt1323594"),of(2019,3,30,15,30),two);
        Showing e = new Showing(films.getFilmById("tt0076759"),of(2019,3,30,16,15),three);
        Showing g = new Showing(films.getFilmById("tt0109830"),of(2019,3,30,13,15),four);
        Showing i = new Showing(films.getFilmById("tt0137523"),of(2019,3,30,13,0),five);
        Showing k = new Showing(films.getFilmById("tt0133093"),of(2019,3,30,14,0),six);
        Showing m = new Showing(films.getFilmById("tt0120815"),of(2019,3,30,15,30),seven);
        Showing o = new Showing(films.getFilmById("tt4154756"),of(2019,3,30,16,15),eight);
        Showing q = new Showing(films.getFilmById("tt0090605"),of(2019,3,30,13,0),nine);
        Showing s = new Showing(films.getFilmById("tt2380307"),of(2019,3,30,13,0),ten);

        Showing b = new Showing(films.getFilmById("tt0499549"),of(2019,4,6,13,0),one);
        Showing d = new Showing(films.getFilmById("tt1323594"),of(2019,4,6,15,30),two);
        Showing f = new Showing(films.getFilmById("tt0076759"),of(2019,4,6,16,15),three);
        Showing h = new Showing(films.getFilmById("tt0109830"),of(2019,4,6,13,15),four);
        Showing j = new Showing(films.getFilmById("tt0137523"),of(2019,4,6,13,0),five);
        Showing l = new Showing(films.getFilmById("tt0133093"),of(2019,4,6,14,0),six);
        Showing n = new Showing(films.getFilmById("tt0120815"),of(2019,4,6,15,30),seven);
        Showing p = new Showing(films.getFilmById("tt4154756"),of(2019,4,6,16,15),eight);
        Showing r = new Showing(films.getFilmById("tt0090605"),of(2019,4,6,13,0),nine);
        Showing t = new Showing(films.getFilmById("tt2380307"),of(2019,4,6,13,0),ten);

        Showing u = new Showing(films.getFilmById("tt0112573"),of(2019,4,13,13,0),one);
        Showing v = new Showing(films.getFilmById("tt0114709"),of(2019,4,13,15,30),two);
        Showing w = new Showing(films.getFilmById("tt1049413"),of(2019,4,13,16,15),three);
        Showing x = new Showing(films.getFilmById("tt0993846"),of(2019,4,13,13,15),four);
        Showing y = new Showing(films.getFilmById("tt0266543"),of(2019,4,13,13,0),five);
        Showing z = new Showing(films.getFilmById("tt6966692"),of(2019,4,13,14,0),six);
        Showing aa = new Showing(films.getFilmById("tt0110357"),of(2019,4,13,15,30),seven);
        Showing ab = new Showing(films.getFilmById("tt0110912"),of(2019,4,13,16,15),eight);
        Showing ac = new Showing(films.getFilmById("tt0120737"),of(2019,4,13,13,0),nine);
        Showing ad = new Showing(films.getFilmById("tt1375666"),of(2019,4,13,13,0),ten);

        Showing ae = new Showing(films.getFilmById("tt0112573"),of(2019,4,20,13,0),one);
        Showing af = new Showing(films.getFilmById("tt0114709"),of(2019,4,20,15,30),two);
        Showing ag = new Showing(films.getFilmById("tt1049413"),of(2019,4,20,16,15),three);
        Showing ah = new Showing(films.getFilmById("tt0993846"),of(2019,4,20,13,15),four);
        Showing ai = new Showing(films.getFilmById("tt0266543"),of(2019,4,20,13,0),five);
        Showing aj = new Showing(films.getFilmById("tt6966692"),of(2019,4,20,14,0),six);
        Showing ak = new Showing(films.getFilmById("tt0110357"),of(2019,4,20,15,30),seven);
        Showing al = new Showing(films.getFilmById("tt0110912"),of(2019,4,20,16,15),eight);
        Showing am = new Showing(films.getFilmById("tt0120737"),of(2019,4,20,13,0),nine);
        Showing an = new Showing(films.getFilmById("tt1375666"),of(2019,4,20,13,0),ten);


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
        showings.addShowing(u);
        showings.addShowing(v);
        showings.addShowing(w);
        showings.addShowing(x);
        showings.addShowing(y);
        showings.addShowing(z);
        showings.addShowing(aa);
        showings.addShowing(ab);
        showings.addShowing(ac);
        showings.addShowing(ad);
        showings.addShowing(ae);
        showings.addShowing(af);
        showings.addShowing(ag);
        showings.addShowing(ah);
        showings.addShowing(ai);
        showings.addShowing(aj);
        showings.addShowing(ak);
        showings.addShowing(al);
        showings.addShowing(am);
        showings.addShowing(an);


//      showings.printShowings();
//      showings.sortFilmsAlphabetically();
//
//      showings.printShowings();
//      System.out.println(showings.getShowingByNumber(1));
//      showings.removeOldShowings();
//      showings.printShowings();
//      System.out.println(a.getRows());



//      showings.saveToTxtFile();

        films.saveFilmsToTxt();
//      System.out.println(showings.getShowings());

        Ticket t1 = new Ticket(a,a.getRowByCharacter("C").getSeatByNumber(1));
        Ticket t2 = new Ticket(a,a.getRowByCharacter("C").getSeatByNumber(2));
        Ticket t3 = new Ticket(g,g.getRowByCharacter("F").getSeatByNumber(4));
        Ticket t4 = new Ticket(c,c.getRowByCharacter("C").getSeatByNumber(1));
        Ticket t5 = new Ticket(e,e.getRowByCharacter("C").getSeatByNumber(2));
        Ticket t6 = new Ticket(g,g.getRowByCharacter("F").getSeatByNumber(4));
        Ticket t7 = new Ticket(i,i.getRowByCharacter("C").getSeatByNumber(1));
        Ticket t8 = new Ticket(k,k.getRowByCharacter("C").getSeatByNumber(2));
        Ticket t9 = new Ticket(m,m.getRowByCharacter("F").getSeatByNumber(5));
        Ticket t10 = new Ticket(o,o.getRowByCharacter("C").getSeatByNumber(1));
        Ticket t11 = new Ticket(q,q.getRowByCharacter("C").getSeatByNumber(2));
        Ticket t12 = new Ticket(s,s.getRowByCharacter("F").getSeatByNumber(4));


        BookingController bookings = new BookingController();
        Booking b1 = new Booking();
        Booking b2 = new Booking();
        Booking b3 = new Booking();
        Booking b4 = new Booking();
        Booking b5 = new Booking();
        Booking b6 = new Booking();
        Booking b7 = new Booking();
        Booking b8 = new Booking();
        Booking b9 = new Booking();
        Booking b10 = new Booking();
        Booking b11 = new Booking();

        b1.addTicket(t1);
        b1.addTicket(t2);
        b2.addTicket(t3);
        b3.addTicket(t4);
        b4.addTicket(t5);
        b5.addTicket(t6);
        b6.addTicket(t7);
        b7.addTicket(t8);
        b8.addTicket(t9);
        b9.addTicket(t10);
        b10.addTicket(t11);
        b11.addTicket(t12);

        bookings.addBooking(b1);
        bookings.addBooking(b2);
        bookings.addBooking(b3);
        bookings.addBooking(b4);
        bookings.addBooking(b5);
        bookings.addBooking(b6);
        bookings.addBooking(b7);
        bookings.addBooking(b8);
        bookings.addBooking(b9);
        bookings.addBooking(b10);
        bookings.addBooking(b11);

        for (Booking booking:bookings.getBookings()) {
            booking.setSeatsAsBooked();
            booking.calculateTotalPrice();
        }
        //System.out.println(a); //Check seats are not linked to theatre and are linked to showing
        //System.out.println(ae); //Expected seats available are 54 & 56

        RefreshmentController snacks = new RefreshmentController();

        String popcornText = "Our popcorn is freshly popped, always carefully selected and you can choose from a range of sweet, salted or mixed";
        String softDrinkText = "We are excited to offer a refreshing range of drinks including Pepsi MAX, Pepsi MAX Cherry, Pepsi, Diet Pepsi, 7up Free, Tango";
        Snack sa = new Snack(5.20,"Popcorn - Large",popcornText, "res/popcorn.jpg");
        Snack sb = new Snack(4.50,"Popcorn - Medium",popcornText, "res/popcorn.jpg");
        Snack sc = new Snack(3.50,"Popcorn - Small",popcornText,"res/popcorn.jpg");
        Drink sd = new Drink(3.20,"Soft Drink - Large",softDrinkText,"res/softdrinks.jpg");
        Drink se = new Drink(2.80,"Soft Drink - Medium", softDrinkText,"res/softdrinks.jpg");
        Drink sf = new Drink(2.00,"Soft Drink - Small",softDrinkText,"res/softdrinks.jpg");
        Drink sg = new Drink(1.50,"Bottled Water","Cool, refreshing water","res/bottledwater.jpg");
        Snack sh = new Snack(2.00,"Hot Dog","Delicious sizzling hot dog, topped with ketchup & mustard.\n","res/hotdog.jpg");
        Snack si = new Snack(2.40,"Nachos","Nachos served with fiery jalapenos and your choice of dip: try them with salsa, warm cheese or sour cream","res/nachos.jpg");
        Drink sj = new Drink(2.90,"Hot Chocolate","Silky smooth hot chocolate. Great for the chocolate lovers","res/hotchocolate.jpg");

        snacks.addSnack(sa);
        snacks.addSnack(sb);
        snacks.addSnack(sc);
        snacks.addSnack(sd);
        snacks.addSnack(se);
        snacks.addSnack(sf);
        snacks.addSnack(sg);
        snacks.addSnack(sh);
        snacks.addSnack(si);
        snacks.addSnack(sj);


        UserController users = new UserController();
        Admin admin = new Admin("Joseph","Fletcher","u1863522@unimail.hud.ac.uk","Joseph","Fletcher");
        Admin admin2 = new Admin("Admin","Istrator","admin@istrator.co.uk","Admin","Admin");
        Employee employee = new Employee("Employee","Number 1","employee1@gmail.com","Employee","Employee",1);
        Employee employee2 = new Employee("Employee","Number 2","employee2@gmail.com","E","E",2);

        users.addUser(admin);
        users.addUser(admin2);
        users.addUser(employee);
        users.addUser(employee2);

//        System.out.println(users.validateUser("Admin","Admin"));//TRUE
//        System.out.println(users.validateUser("E","E"));//TRUE
//        System.out.println(users.validateUser("Not","InArray"));//FALSE
//        System.out.println(users.getUserByUsername("Admin"));//Return Admin object
//        System.out.println(users.getUserByUsername("E"));//Return Employee Object
//
//        System.out.println(bookings);
        bookings.saveBookings();
        showings.saveShowings();
        theaters.saveTheaters();
        showings.saveShowings();
        snacks.saveSnacks();
        users.saveUsers();
        }
    }