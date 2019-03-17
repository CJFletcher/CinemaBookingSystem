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

    @Override
    public String toString() {
        String ret = "";
        for(BuyableItem item:items){
            ret += item+"\n";
        }

        return "Items in Basket:\n"+ ret;
    }
}
