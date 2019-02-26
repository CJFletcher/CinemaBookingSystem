package model;

import java.time.LocalDate;

public class Film {


    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int runTimeMinutes;
    private int id;

    public Film(String title, String description, LocalDate startDate, LocalDate endDate, int runTimeMinutes, int id) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.runTimeMinutes = runTimeMinutes;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", runTimeMinutes=" + runTimeMinutes +
                ", id=" + id +
                '}';
    }
}