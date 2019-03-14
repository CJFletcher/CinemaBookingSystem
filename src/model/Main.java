package model;

import controller.BookingController;
import controller.FilmController;
import controller.ShowingController;
import controller.TheaterController;
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
    private static User currentUser;
    private static Showing currentShowing;
    private static Theater currentTheater;

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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TheaterController t = new TheaterController();
        FilmController f = new FilmController();
        ShowingController s = new ShowingController();
        BookingController b = new BookingController();

        t.loadTheaters();
        f.loadFilms();
        s.loadShowings();
        b.loadBookings();

        theaters = t;
        films = f;
        showings = s;
        bookings = b;

        System.out.println(s.getShowings());

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