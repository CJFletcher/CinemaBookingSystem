package model;

import java.io.Serializable;
import java.text.DecimalFormat;

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

    public String getPriceFormatted() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "£" + df.format(getPrice());
    }
}
