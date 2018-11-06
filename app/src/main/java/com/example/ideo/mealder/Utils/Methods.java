package com.example.ideo.mealder.Utils;

public class Methods {

    public static boolean loginIsCorrect(String login){
        if (login.trim().equals("login"))
            return true;
        else return false;
    }

    public static boolean passwordIsCorrect(String password){
        if (password.trim().equals("password"))
            return true;
        else return false;
    }
}
