package model;

public class Snack extends BuyableItem{
    private String name;
    private String description;

    public Snack(double price, String name, String description) {
        super(price);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
