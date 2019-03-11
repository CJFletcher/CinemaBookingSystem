package model;

import java.io.Serializable;

public abstract class BuyableItem implements Serializable{
    private double price;

    public BuyableItem(double price) {
        this.price = price;
    }

    public BuyableItem() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
