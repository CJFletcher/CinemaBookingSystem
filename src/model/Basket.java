package model;

import model.BuyableItem;
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
        items.removeIf(s -> s == item);
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
