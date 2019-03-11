package model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;
import java.util.ArrayList;

//SerializedName matches the Value from the Json response to the relevant attribute.
//This is necessary due to the Json response Values being stored capitalised.

public class Film implements Serializable {
    @SerializedName(value = "Title", alternate = "title")
    private String title;
    @SerializedName(value = "Year",alternate = "year")
    private String year;
    @SerializedName(value = "Rated",alternate = "rated")
    private String rated;
    @SerializedName(value = "Released",alternate = "released")
    private String released;
    @SerializedName(value = "Runtime",alternate = "runtime")
    private String runtime;
    @SerializedName(value = "Genre",alternate = "genre")
    private String genre;
    @SerializedName(value = "Director",alternate = "director")
    private String director;
    @SerializedName(value = "Writer",alternate = "writer")
    private String writer;
    @SerializedName(value = "Actors",alternate = "actors")
    private String actors;
    @SerializedName(value = "Plot",alternate = "plotShort")
    private String plotShort;
    @SerializedName(value = "Language",alternate = "language")
    private String language;
    @SerializedName(value = "Country",alternate = "country")
    private String country;
    @SerializedName(value = "Awards",alternate = "awards")
    private String awards;
    @SerializedName(value = "Poster",alternate = "poster")
    private String poster;
    @SerializedName(value = "Ratings",alternate = "ratings")
    ArrayList<LinkedTreeMap> ratings = new ArrayList<>();
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    @SerializedName(value = "imdbID",alternate = "imdbId")
    private String imdbId;
    @SerializedName(value = "Type",alternate = "type")
    private String type;
    @SerializedName(value = "DVD",alternate = "dvd")
    private String dvd;
    @SerializedName(value = "BoxOffice",alternate = "boxOffice")
    private String boxOffice;
    @SerializedName(value = "Production",alternate = "production")
    private String production;
    @SerializedName(value = "Website",alternate = "website")
    private String website;

    public Film() {
    }

    // Getter Methods

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlotShort() {
        return plotShort;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public String getRatings() {
        String ret = "";
        for (LinkedTreeMap rating : ratings) {
            ret += rating.get("Source") + " " + rating.get("Value")+"\n";
        }
        return ret;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getType() {
        return type;
    }

    public String getDvd() {
        return dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public String getWebsite() {
        return website;
    }

    // Setter Methods

    public void setTitle(String Title) {
        this.title = Title;
    }

    public void setYear(String Year) {
        this.year = Year;
    }

    public void setRated(String Rated) {
        this.rated = Rated;
    }

    public void setRuntime(String Runtime) {
        this.runtime = Runtime;
    }

    public void setGenre(String Genre) {
        this.genre = Genre;
    }

    public void setDirector(String Director) {
        this.director = Director;
    }

    public void setWriter(String Writer) {
        this.writer = Writer;
    }

    public void setActors(String Actors) {
        this.actors = Actors;
    }

    public void setPlotShort(String Plot) {
        this.plotShort = Plot;
    }

    public void setLanguage(String Language) {
        this.language = Language;
    }

    public void setCountry(String Country) {
        this.country = Country;
    }

    public void setAwards(String Awards) {
        this.awards = Awards;
    }

    public void setPoster(String Poster) {
        this.poster = Poster;
    }

    public void setMetascore(String Metascore) {
        this.metascore = Metascore;
    }

    public void setRatings(ArrayList<LinkedTreeMap> ratings) {
        this.ratings = ratings;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setType(String Type) {
        this.type = Type;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public void setBoxOffice(String BoxOffice) {
        this.boxOffice = BoxOffice;
    }

    public void setProduction(String Production) {
        this.production = Production;
    }

    public void setWebsite(String Website) {
        this.website = Website;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", rated='" + rated + '\'' +
                ", runtime='" + runtime + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", writer='" + writer + '\'' +
                ", actors='" + actors + '\'' +
                ", plotShort='" + plotShort + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                ", ratings=" + ratings +
                ", metascore='" + metascore + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", imdbVotes='" + imdbVotes + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", type='" + type + '\'' +
                ", dvd='" + dvd + '\'' +
                ", boxOffice='" + boxOffice + '\'' +
                ", production='" + production + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}

