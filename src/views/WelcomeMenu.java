package views;

import controllers.WelcomeController;
import enums.Message;

public class WelcomeMenu extends Menu {
    private static WelcomeMenu instance = null;
    private WelcomeController welcomeController = null;
    private WelcomeMenu()
    {
        this.welcomeController = WelcomeController.getInstance();
    }
    private static void setInstance(WelcomeMenu instance)
    {
        WelcomeMenu.instance = instance;
    }
    public static WelcomeMenu getInstance()
    {
        if (WelcomeMenu.instance == null)
            WelcomeMenu.setInstance(new WelcomeMenu());
        return WelcomeMenu.instance;
    }

    @Override
    public void run() {
        this.showOptions();
        String choice = this.getChoice();
        switch (choice){
            case "1":
            case "register":
                this.register();
                break;
                
            case "2":
            case "login":
                this.login();
                break;

            case "3":
            case "exit":
                this.exit();
                break;
            default:
                System.out.println(Message.INVALID_Choice);
        }

    }

    private void login() {
       String userName = this.message("user name");
       String password = this.message("password");
       Message message = this.welcomeController.handleLogin(userName, password);
       if (message == Message.SUCCESS){
           MainMenu.getInstance().run();
       }
       else
           System.out.println(message);
       this.run();
    }

    private void register() {
        System.out.println("login as Admin or Customer :");
        String choice = this.getChoice();
       if (choice.equals("customer"))
           this.registerCustomer();
       else if (choice.equals("admin"))
           this.registerAdmin();
       else
           System.out.println(Message.INVALID_Choice);
       this.run();
    }
    private void registerAdmin()
    {
        String userName = this.message("user name");
        String password = this.message("password");
        String repeatedPassword = this.message("repeat password");
        String role = this.message("enter role (CEO/MANAGEMENT/SIMPLE)");
        Message message = this.welcomeController.handleCreateAdmin(userName, password, repeatedPassword, role);
        if (message == Message.SUCCESS){
            System.out.println("admin registered successfully");
        }
        else
            System.out.println(message);
        this.run();
    }
    private void registerCustomer() {
        String userName = this.message("user name");
        String password = this.message("password");
        String repeatedPassword = this.message("repeat password");
        Message message = this.welcomeController.handleCreateCustomer(userName, password, repeatedPassword);
        if (message == Message.SUCCESS){
            System.out.println("customer registered successfully");
        }
        else
            System.out.println(message);
        this.run();
    }
    private void exit() {
        Menu.getScanner().close();
    }
    @Override
    protected void showOptions() {
        System.out.println("enter a option:");
        System.out.println("1. register");
        System.out.println("2. login");
        System.out.println("3. exit");
    }
}