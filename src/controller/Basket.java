package controller;

import model.BuyableItem;
import java.util.ArrayList;

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
}
