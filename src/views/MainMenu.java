package views;

import controllers.MainController;
import enums.Message;
import models.Admin;
import models.Customer;
import models.Saleable;
import models.User;

import java.util.ArrayList;

public class MainMenu extends Menu{
    private static MainMenu instance = null;
    private final MainController mainController;
    private MainMenu() {
        this.mainController = MainController.getInstance();
    }
    private static void setInstance(MainMenu mainMenu){
        MainMenu.instance = mainMenu;
    }
    public static MainMenu getInstance(){
        if (MainMenu.instance == null)
            MainMenu.setInstance(new MainMenu());
        return MainMenu.getInstance();
    }
    private void showAdminChoices(){
        System.out.println("2. add new product");
        System.out.println("3. edit product");
        System.out.println("4. profile");

    }
    private void showCustomerChoices()
    {
        System.out.println("2. by a product");
        System.out.println("3. add new service");
        System.out.println("4. add comment");
        System.out.println("5. profile");

    }
    @Override
    public void run() {
        this.showOptions();
        User user = Menu.getLoggedInUser();
        String choice = this.getChoice();
        if (user instanceof Admin)
            this.handleAdminChoice(choice);
        else if (user instanceof Customer)
            this.handleCustomerChoice(choice);

    }

    private  void  handleAdminChoice(String choice) {
        switch (choice){
            case "1":
                this.showProductsAndServices();
                break;
            case "2":
                this.addProduct();
                break;
            case "3":
                this.editProduct();
                break;
            case "4":
                this.goToProfile();
            default:
                System.out.println(Message.INVALID_Choice);

        }
    }

    private void goToProfile() {
    }

    private void editProduct() {
    }

    private void addProduct() {
        System.out.println("enter information");
        String name = this.message("enter name");
        int price = Integer.parseInt(this.message("enter price"));
        int capacity = Integer.parseInt(this.message("enter capacity"));
        String description = this.message("enter description");
       Message message = this.mainController.handleAddProduct(name, price, capacity, description);
       if (message == Message.SUCCESS)
           System.out.println("profile added successfully");
       else
           System.out.println(message);
       this.run();

    }

    private void showProductsAndServices() {
        ArrayList<Saleable> allItems = this.mainController.handleShowProductsAndServices();
        for (Saleable item : allItems)
            System.out.println(item);
        this.run();
    }

    private void handleCustomerChoice(String choice) {
        switch (choice){
            case "1":
                this.showProductsAndServices();
                break;
            case "2":
                this.buyPrpduct();
                break;
            case "3":
                this.addServise();
                break;
            case "4":
                this.addComment();
                break;
            case "5":
                this.goToProfile();
            default:
                System.out.println(Message.INVALID_Choice);
        }
    }

    private void addComment() {
    }

    private void addServise() {
    }

    private void buyPrpduct() {
    }

    @Override
    protected void showOptions() {
        System.out.println("enter one of the choices:");
        System.out.println("1. show products and services");
        User user = MainMenu.getLoggedInUser();
        if (user instanceof Admin)
            this.showAdminChoices();
        else if (user instanceof Customer)
            this.showCustomerChoices();
    }
}
