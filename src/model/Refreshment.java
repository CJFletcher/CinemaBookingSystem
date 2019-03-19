package model;

public abstract class Refreshment extends BuyableItem{
    private String name;
    private String description;
    private String refreshmentType;
    private String imagePath;

    public Refreshment(double price, String name, String description) {
        super(price);
        this.name = name;
        this.description = description;
    }

    public Refreshment(double price, String name, String description, String imagePath) {
        super(price);
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
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

    public String getRefreshmentType() {
        return refreshmentType;
    }

    public void setRefreshmentType(String refreshmentType) {
        this.refreshmentType = refreshmentType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getRefreshmentFormatted(){
        return this.getName()+"\n\n"+this.getDescription()+"\n\n"+this.getPriceFormatted();
    }


    @Override
    public String toString() {
        return name + ": " + super.getPriceFormatted();
    }
}
