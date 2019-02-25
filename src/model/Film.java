package model;

import java.util.Date;

public class Film {


    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int id;

    public Film(String title, String description, Date startDate, Date endDate, int id) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
    }

    public Film(String title, int id){
        this.title = title;
        this.description = "";
        this.startDate = new Date(2001,01,01);
        this.endDate = new Date(2001,01,01);
        this.id = 1;
    }


    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", id=" + id +
                '}';
    }
}
