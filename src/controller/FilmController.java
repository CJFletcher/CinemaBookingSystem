package controller;

import com.google.gson.Gson;
import model.Film;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import static controller.TextFileScanner.txtToArray;

import static controller.HelperClass.replaceSpacesInString;

public class FilmController {

    private static String APIKEY = "3d4916dd";

    private ArrayList<Film> films;

    public FilmController() {
        this.films = new ArrayList<>();
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    public void removeFilm(Film film) {
        this.films.remove(film);
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void filterFilmsByTitle(String title) {
        if (this.films.isEmpty()) {
            System.out.println("No films in this collection.");
        } else {
            for (Film i : films) {
                if (i.getTitle().contains(title)) {
                    System.out.println(i);
                }
            }
        }
    }

    public ArrayList<Film> getAllFilms() {
        ArrayList<Film> ret = new ArrayList<Film>();
        if (this.films.isEmpty()) {
            System.out.println("No films in this collection.");
        } else {
            for (Film i : films)
                ret.add(i);
        }
        return ret;
    }


    public static URL generateOmdbUrl(String filmName, String filmYear) throws IOException{
        String filmNameNoSpaces = replaceSpacesInString(filmName, "+");
        if (filmYear == null) {
            URL url = new URL("http://www.omdbapi.com/?t=" + filmNameNoSpaces + "&apikey=" + APIKEY);
            return url;
        } else {
            URL url = new URL("http://www.omdbapi.com/?t=" + filmNameNoSpaces + "&y=" + filmYear + "&apikey=" + APIKEY);
            return url;
        }
    }

    public static URL generateOmdbUrl(String imdbID) throws IOException {
        {
            URL url = new URL("http://www.omdbapi.com/?i=" + imdbID + "&apikey=" + APIKEY);
            return url;
        }
    }

    public static String parseURL(URL url)throws IOException {
        String ret = "";
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            ret += new String(buffer, 0, count);
        }
        bis.close();
        String retLower = ret.toLowerCase();
        System.out.println(ret);
        return ret;
    }

    public static Film jsonToObject(String json){
        Film data = new Gson().fromJson(json, Film.class);
        return(data);
    }

    public static Film newFilm(String filmName, String filmYear) throws IOException{
        return(jsonToObject(parseURL(generateOmdbUrl(filmName,filmYear))));
    }

    public static Film newFilm(String imdbID) throws IOException{
        return(jsonToObject(parseURL(generateOmdbUrl(imdbID))));
    }

    public Film getFilmByName(String filmName){
        for (Film film:this.films) {
            if (film.getTitle().toLowerCase().contains(filmName.toLowerCase())) {
                return film;
            }
        }
        throw new NoSuchElementException("Film not found");
    }

    public void printFilms() {
        if (this.films.isEmpty()) {
            System.out.println("No films in this collection.");
            System.out.println();
        } else {
            System.out.println("Films:\n");
            for (Film i : films) {
                System.out.println(i);
            }
        }
    }

    public void loadFilms() throws IOException {
        ArrayList<String> filmIds =txtToArray("./src/txt/films.txt");
        for (String filmid:filmIds) {
            films.add(newFilm(filmid));
            }
    }
}