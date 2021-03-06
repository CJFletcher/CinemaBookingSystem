package controller;

import com.google.gson.Gson;
import model.Film;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.*;

import static controller.TextFileScanner.arrayOfStringsToTxt;
import static controller.TextFileScanner.txtToArray;
import static controller.HelperClass.replaceSpacesInString;

public class FilmController implements Serializable {

    private final static String APIKEY = "3d4916dd";
    private final static String TXTFILEPATH = "./src/data/films.txt";
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

    public void removeNullFilms() {
        Iterator<Film> i = films.iterator();
        while (i.hasNext()) {
            Film f = i.next();
            if (f.getTitle() == null) {
                i.remove();
            }
        }
    }

    public void sortFilmsAlphabetically() {
        Collections.sort(this.films);
    }

    public ArrayList<Film> filterFilmsByTitle(String title) {
        ArrayList<Film> ret = new ArrayList<>();
        if (this.films.isEmpty()) {
            System.out.println("There are no films in this list");
            return null;
        } else {
                for (Film f : films) {
                    try{
                    if (f.getTitle().contains(title)) {
                        ret.add(f);
                    }
                    }catch (NullPointerException e){
                        System.out.println(e+" Film with no title found. Deleting...");
                    }
                }
            removeNullFilms();
            return ret;
        }
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
        return ret;
    }

    public static Film jsonToObject(String json){
        Film data = new Gson().fromJson(json, Film.class);
        return(data);
    }

    public static Film newFilm(String filmName, String filmYear) throws IOException{
        if(jsonToObject(parseURL(generateOmdbUrl(filmName,filmYear))).getTitle()==null){
            throw new NullPointerException("No such film exists");
        }
        else{
            return jsonToObject(parseURL(generateOmdbUrl(filmName,filmYear)));
        }
    }

    public static Film newFilm(String imdbID) throws IOException{
        if (imdbID!=null){
            return jsonToObject(parseURL(generateOmdbUrl(imdbID)));
        }
        throw new NullPointerException("No film with id exists");
    }

    public Film getFilmByTitle(String filmTitle){
        if (!films.isEmpty()) {
            for (Film film : this.films) {
                if (film.getTitle().toLowerCase().contains(filmTitle.toLowerCase())) {
                    return film;
                }
            }
            throw new NoSuchElementException("Film not found");
        }
        throw new NullPointerException("Films list is empty");
    }

    public Film getFilmById(String filmId){
        for (Film film:this.films) {
            if (film.getImdbId().toLowerCase().contains(filmId.toLowerCase())) {
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

    public void saveFilmsToTxt() throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        if (this.films.isEmpty()) {
            System.out.println("No films in this collection.");
        } else {
            for (Film i : films)
                strings.add(i.getImdbId());
        }
        arrayOfStringsToTxt(strings,TXTFILEPATH);
    }


    public void loadFilms() throws IOException {
        ArrayList<String> filmIds=txtToArray(TXTFILEPATH);
        for (String filmid:filmIds) {
            films.add(newFilm(filmid));
        }
    }
}