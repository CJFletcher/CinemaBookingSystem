package model;

import java.util.Currency;

public abstract class BuyableItem implements ClassWithID{
    private Currency price;

    public BuyableItem(Currency price) {
        this.price = price;
    }
}
