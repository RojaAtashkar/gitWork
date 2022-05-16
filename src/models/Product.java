package models;

public class Product extends Saleable {
    private String description;
    private int capacity;
    Product(String name, int price, String description, int capacity){
        super(name, price);
        this.capacity = capacity;
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString(){
        return super.toString() + "| capacity: " + this.getCapacity() + "| description: " + this.getDescription();
    }
}
