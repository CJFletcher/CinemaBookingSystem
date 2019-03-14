package model;

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

    public void addItem(BuyableItem item) {
        this.items.add(item);
    }

    public void removeItem(BuyableItem item) {
        this.items.remove(item);
    }
}
