package model;

public class Drink extends Refreshment {

    public Drink(double price, String name, String description) {
        super(price, name, description);
        setRefreshmentType("Drink");
    }

    public Drink(double price, String name, String description, String imagePath) {
        super(price, name, description, imagePath);
        setRefreshmentType("Drink");
    }

    @Override
    public String toString() {
        return this.getName()+ ": " + super.getPriceFormatted();
    }
}
