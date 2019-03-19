package model;

public class Snack extends Refreshment {

    public Snack(double price, String name, String description) {
        super(price, name, description);
        setRefreshmentType("Snack");
    }

    public Snack(double price, String name, String description, String imagePath) {
        super(price, name, description, imagePath);
        setRefreshmentType("Snack");
    }

    @Override
    public String toString() {
        return this.getName()+ ": " + super.getPriceFormatted();
    }
}
