package models;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Saleable implements Comparable<Saleable>{
    private static final ArrayList<Saleable> allItems = new ArrayList<>();
    private static int idCounter = 0;
    private  int uniqueID;
    private String name;
    private int price;
    public Saleable(String name, int price){
        this.uniqueID = idCounter++;
        this.name = name;
        this.price = price;
        Saleable.allItems.add(this);
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Saleable.idCounter = idCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }
    public static ArrayList<Saleable> getAllItems(){
        Collections.sort(Saleable.allItems);
        return Saleable.allItems;
    }
    @Override
    public int compareTo(Saleable saleable){
        if (!this.getName().equals(saleable.getName()))
            return this.getName().compareTo(saleable.getName());
        if (this.getPrice() > saleable.getPrice())
            return 1;
        return 0;
    }
    @Override
    public String toString(){
        return "id: " + this.getUniqueID() + "| name: " + this.getName() + "| price: " + this.getPrice();
    }



}
