package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;



public class Booking implements Serializable {
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private String id = "BKG-" +LocalDate.now() +"-"+ UUID.randomUUID().toString().substring(0,13);

    public Booking() {
    }

    public Booking(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static void main(String[] args) {
        Booking test = new Booking();
        Booking test2 = new Booking();
        System.out.println(test.getId());
        System.out.println(test2.getId());
    }

    public void setSeatsAsBooked() {
        for (Ticket ticket : tickets) {
            ticket.getSeat().setBookingStatus(true);
        }
    }

    public void setSeatsAsUnBooked() {
        for (Ticket ticket : tickets) {
            ticket.getSeat().setBookingStatus(false);
        }
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Booking ID: " + id + " | Tickets: "+ tickets;
    }
}
