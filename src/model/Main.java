package model;

import controller.FilmController;
import controller.ShowingController;
import controller.TheaterController;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TheaterController theaters = new TheaterController();
        FilmController films = new FilmController();
        ShowingController showings = new ShowingController();

        theaters.loadTheaters();
        films.loadFilms();
        showings.loadShowings();

    }
}
