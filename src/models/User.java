package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;public abstract class User {
    private static  ArrayList<User> allUsers = new ArrayList<>();
    private static int id = 0;
    private int UserId;
    private final String creat_At;
    private String username;
    private String password;
    User(String username, String password){
        this.username = username;
        this.password = password;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/mm/dd || HH:mm:ss ");
        this.creat_At = now.format(formatter);
        allUsers.add(this);
    }
    public static User getUserByUserName(String username){
        for (User user : allUsers)
            if (user.username.equals(username))
                return user;
        return null;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    public String getCreat_At() {
        return creat_At;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}



