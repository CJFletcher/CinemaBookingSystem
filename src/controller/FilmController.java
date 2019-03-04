package controller;

import com.google.gson.Gson;
import model.Film;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static controller.HelperClass.replaceSpacesInString;

public class FilmController {

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

    public static URL generateOmdbUrl(String filmName, String filmYear) throws IOException{
        String apiKey = "3d4916dd";
        String filmNameNoSpaces = replaceSpacesInString(filmName, "+");
        if (filmYear == null) {
            URL url = new URL("http://www.omdbapi.com/?t=" + filmNameNoSpaces + "&apikey=" + apiKey);
            return url;
        } else {
            URL url = new URL("http://www.omdbapi.com/?t=" + filmNameNoSpaces + "&y=" + filmYear + "&apikey=" + apiKey);
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
        return retLower;
    }

    public static Film jsonToObject(String json){
        Film data = new Gson().fromJson(json, Film.class);
        return(data);
    }

    public static Film newFilm(String filmName, String filmYear) throws IOException{
        return(jsonToObject(parseURL(generateOmdbUrl(filmName,filmYear))));
    }

    public Film getFilmByName(String filmName){
        for (Film film:this.films
             ) {
            if (film.getTitle().contains(filmName.toLowerCase())) {
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
            for (Film i : films) {
                System.out.println(i);
            }
        }
    }
}