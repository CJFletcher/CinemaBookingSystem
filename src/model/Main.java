package model;

import controller.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application {

    private static Parent root;
    private static Stage primaryStage;
    private static UserController users;
    private static TheaterController theaters;
    private static FilmController films;
    private static ShowingController showings;
    private static BookingController bookings;
    private static RefreshmentController refreshments;
    private static User currentUser;
    private static Showing currentShowing;
    private static Basket basket;

    public static Stage getStage() {
        return primaryStage;
    }

    public static void setStage(Stage primaryStage) {
        Main.primaryStage = primaryStage;
    }

    public static void setRoot(Parent root) {
        Main.root = root;
    }

    public static Parent getRoot() {
        return root;
    }

    public static UserController getUsers() {
        return users;
    }

    public static void setUsers(UserController users) {
        Main.users = users;
    }

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

    public static RefreshmentController getRefreshments() {
        return refreshments;
    }

    public static Basket getBasket() {
        return basket;
    }

    public static void setBasket(Basket basket) {
        Main.basket = basket;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        theaters = new TheaterController();
        films = new FilmController();
        showings = new ShowingController();
        bookings = new BookingController();
        refreshments = new RefreshmentController();
        basket = new Basket();
        users = new UserController();

        theaters.loadTheaters();
        films.loadFilms();
        showings.loadShowings();
        bookings.loadBookings();
        refreshments.loadSnacks();
        users.loadUsers();

        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("Cinema Booking System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });

    }
}