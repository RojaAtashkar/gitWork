package controllers;

import enums.Message;
import models.Product;
import models.Saleable;

import java.util.ArrayList;

public class MainController {
    private static MainController instance = null;
    private MainController(){

    }
    private static void setInstance(MainController instance){
        MainController.instance = instance;
    }
    public  static MainController getInstance(){
        if (MainController.instance == null)
        {
            MainController.setInstance(new MainController());
        }
            return MainController.instance;
    }

    public ArrayList<Saleable> handleShowProductsAndServices() {
        return Saleable.getAllItems();
    }

    public Message handleAddProduct(String name, int price, int capacity, String description) {
        for (Saleable item : Saleable.getAllItems()){
            if (item instanceof Product && item.getName().equals(name) && item.getPrice() == price
            && ((Product) item).getCapacity() == capacity && ((Product) item).getDescription().equals(description))
            {
                return Message.PRODUCT_EXIST;
            }
        }
        return Message.SUCCESS;
    }
}
