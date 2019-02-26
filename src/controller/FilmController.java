package controller;

import com.google.gson.Gson;
import model.Film;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

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

    public static String downloadFilmInfo(String filmName, int filmYear) throws IOException {
        String apiKey = "3d4916dd";
        String filmNameNoSpaces = replaceSpacesInString(filmName,"+");
        URL url = new URL("http://www.omdbapi.com/?t="+filmNameNoSpaces+"&y="+filmYear+"&apikey="+apiKey);
        String ret = "";
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            ret += new String(buffer, 0, count);
        }
        bis.close();
        return ret;
    }

    public static String downloadFilmInfo(String filmName) throws IOException {
        String apiKey = "3d4916dd";
        String filmNameNoSpaces = replaceSpacesInString(filmName,"+");
        URL url = new URL("http://www.omdbapi.com/?t="+filmNameNoSpaces+"&apikey="+apiKey);
        String ret = "";
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            ret += new String(buffer, 0, count);
        }
        bis.close();
        return ret;
    }

    public static Film jsonToObject(String json){
        Film data = new Gson().fromJson(json, Film.class);
        return(data);
    }

    public static Film newFilm(String filmName, int filmYear) throws IOException{
        return(jsonToObject(downloadFilmInfo(filmName,filmYear)));
    }

    public static Film newFilm(String filmName) throws IOException{
        return(jsonToObject(downloadFilmInfo(filmName)));
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
