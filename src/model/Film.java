package model;

import java.util.ArrayList;

//All attributes and attribute names in this class are all lowercase rather than lower camel case.
//This is due to the GSON library I have used.
//The JSON formatted String returned from OMDB returns the JSON keys capitalised, so I converted all these keys to
//lowercase to avoid confusion.

public class Film {
    private String title;
    private String year;
    private String rated;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String poster;
    ArrayList< Object > ratings = new ArrayList < Object > ();
    private String metascore;
    private String imdbrating;
    private String imdbvotes;
    private String imdbid;

    public Film() {
    }

    private String type;
    private String dvd;
    private String boxOffice;
    private String production;
    private String website;


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

    public String getPlot() {
        return plot;
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

    public String getMetascore() {
        return metascore;
    }

    public String getImdbrating() {
        return imdbrating;
    }

    public String getImdbvotes() {
        return imdbvotes;
    }

    public String getImdbid() {
        return imdbid;
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

    public void setPlot(String Plot) {
        this.plot = Plot;
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

    public void setImdbrating(String imdbrating) {
        this.imdbrating = imdbrating;
    }

    public void setImdbvotes(String imdbvotes) {
        this.imdbvotes = imdbvotes;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
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
                ", plot='" + plot + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", awards='" + awards + '\'' +
                ", poster='" + poster + '\'' +
                ", ratings=" + ratings +
                ", metascore='" + metascore + '\'' +
                ", imdbrating='" + imdbrating + '\'' +
                ", imdbvotes='" + imdbvotes + '\'' +
                ", imdbid='" + imdbid + '\'' +
                ", type='" + type + '\'' +
                ", dvd='" + dvd + '\'' +
                ", boxOffice='" + boxOffice + '\'' +
                ", production='" + production + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}

