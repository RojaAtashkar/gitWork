import views.WelcomeMenu;

import java.util.WeakHashMap;

public class Main {
    public static void main(String [] args)
    {
        WelcomeMenu welcomeMenu = WelcomeMenu.getInstance();
        welcomeMenu.run();
    }
}
