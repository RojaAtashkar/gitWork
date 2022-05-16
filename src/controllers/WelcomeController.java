package controllers;

import enums.Message;
import enums.Role;
import models.Admin;
import models.Customer;
import models.User;
import views.Menu;

public class WelcomeController extends Controller {
    private static WelcomeController instance = null;
    private WelcomeController(){

    }
    private static void setInstance(WelcomeController welcomeController)
    {
        WelcomeController.instance = welcomeController;
    }
    public static WelcomeController getInstance(){
        if (WelcomeController.instance == null)
            setInstance(new WelcomeController());
        return WelcomeController.instance;
    }

    private boolean doesUserNameExist(String userName){
        return User.getUserByUserName(userName) != null;
    }

    private boolean isNumeric(String password){
        return !password.matches("[a-zA-z]");
    }
    private Message validatePassword(String password, String repeatedPassword){
        if (!password.equals(repeatedPassword))
            return Message.MISMATCH_PASSWORD;
        if (password.length() < 5)
            return Message.SHORT_PASSWORD;
        if (password.length() > 10)
            return Message.LONG_PASSWORD;
        if (!isNumeric(password))
            return Message.NON_Alfa_Numeric_Password;
        return Message.SUCCESS;
    }
    public Message handleLogin(String userName, String password) {
        User user = User.getUserByUserName(userName);
        if (user != null && user.getPassword().equals(password)) {
            Menu.setLoggedInUser(user);
            return Message.SUCCESS;
        }
        return Message.WRONG_CREDENTIALS;
    }
    public Message handleCreateAdmin(String userName, String password, String repeatedPassword, String   role) {
        if (this.doesUserNameExist(userName)){
            return Message.USER_EXIST;
        }
        Message message = this.validatePassword(password, repeatedPassword);
        if (message  != Message.SUCCESS)
            return message;
        Role adminRole = Role.getRoleFromString(role);
        if (adminRole == null)
            return Message.INVALID_ROLE;
        new Admin(userName, password, adminRole);
        return Message.SUCCESS;
    }
    public Message handleCreateCustomer(String userName, String password, String repeatedPassword) {
        if (this.doesUserNameExist(userName)){
            return Message.USER_EXIST;
        }
        Message message = this.validatePassword(password, repeatedPassword);
        if (message  != Message.SUCCESS)
            return message;
         new Customer(userName, password);
        return Message.SUCCESS;
    }
}
