package model;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    private static TheaterController theaters;
    private static FilmController films;
    private static ShowingController showings;
    private static BookingController bookings;
    private static SnackController snacks;
    private static User currentUser;
    private static Showing currentShowing;
    private static Theater currentTheater;
    private static Film currentFilm;
    private static Basket basket;


    public static TheaterController getTheaters() {
        return theaters;
    }

    public static FilmController getFilms() {
        return films;
    }

    public static ShowingController getShowings() {
        return showings;
    }

    public static BookingController getBookings() {
        return bookings;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static Showing getCurrentShowing() {
        return currentShowing;
    }

    public static void setCurrentUser(User currentUser) {
        Main.currentUser = currentUser;
    }

    public static void setCurrentShowing(Showing currentShowing) {
        Main.currentShowing = currentShowing;
    }

    public static Theater getCurrentTheater() {
        return currentTheater;
    }

    public static void setCurrentTheater(Theater currentTheater) {
        Main.currentTheater = currentTheater;
    }

    public static SnackController getSnacks() {
        return snacks;
    }

    public static Film getCurrentFilm() {
        return currentFilm;
    }

    public static void setCurrentFilm(Film currentFilm) {
        Main.currentFilm = currentFilm;
    }

    public static Basket getBasket() {
        return basket;
    }

    public static void setBasket(Basket basket) {
        Main.basket = basket;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TheaterController t = new TheaterController();
        FilmController f = new FilmController();
        ShowingController s = new ShowingController();
        BookingController b = new BookingController();
        SnackController sn = new SnackController();
        Basket bas = new Basket();

        t.loadTheaters();
        f.loadFilms();
        s.loadShowings();
        b.loadBookings();
        sn.loadSnacks();

        theaters = t;
        films = f;
        showings = s;
        bookings = b;
        snacks = sn;
        basket = bas;

        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        primaryStage.setTitle("Cinema Booking System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}