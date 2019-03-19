package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Basket {
    private ArrayList<BuyableItem> items = new ArrayList<>();

    public Basket() {
    }

    public ArrayList<BuyableItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BuyableItem> items) {
        this.items = items;
    }

    public void addItem(BuyableItem item) {
        this.items.add(item);
    }

    public void removeItem(BuyableItem item) {
        Iterator<BuyableItem> i = items.iterator();
        while (i.hasNext()) {
            BuyableItem s = i.next();
            if (s==item) {
                i.remove();
                break;
            }
        }
    }

    public void removeAllIdenticalItems(BuyableItem item){
        items.removeIf(s -> s == item);
    }


    public double calculateTotalPrice(){
        double d = 0;
        for (BuyableItem item: items) {
            d+=item.getPrice();
        }
        return d;
    }


    public static ArrayList<Ticket> getAllTicketsInBasket() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        for (BuyableItem item : Main.getBasket().getItems()) {
            if (item.getClass() == Ticket.class) {
                Ticket ticketInBasket = (Ticket) item;
                tickets.add(ticketInBasket);
            }
        }
        return tickets;
    }

    public static ArrayList<Snack> getAllSnacksInBasket() {
        ArrayList<Snack> snacks = new ArrayList<>();
        for (BuyableItem item : Main.getBasket().getItems()) {
            if (item.getClass()== Snack.class) {
                Snack snackInBasket = (Snack) item;
                snacks.add(snackInBasket);
            }
        }
        return snacks;
    }


    public static ArrayList<Refreshment> getAllRefreshmentsInBasket() {
        ArrayList<Refreshment> refreshments = new ArrayList<>();
        for (BuyableItem item : Main.getBasket().getItems()) {
            if (item instanceof Refreshment) {
                Refreshment refreshmentInBasket = (Refreshment) item;
                refreshments.add(refreshmentInBasket);
            }
        }
        return refreshments;
    }


    public static ArrayList<Drink> getAllDrinksInBasket() {
        ArrayList<Drink> drinks = new ArrayList<>();
        for (BuyableItem item : Main.getBasket().getItems()) {
            if (item.getClass()== Drink.class) {
                Drink drinkInBasket = (Drink) item;
                drinks.add(drinkInBasket);
            }
        }
        return drinks;
    }


    @Override
    public String toString() {
        String ret = "";
        for(BuyableItem item:items){
            ret += item+"\n";
        }

        return "Items in Basket:\n"+ ret;
    }
}
