package com.example.ideo.mealder.Utils;

import android.content.Context;

public class Methods {

    public static boolean loginIsCorrect(String login) {
        if (login.trim().equals("login"))
            return true;
        else return false;
    }

    public static boolean passwordIsCorrect(String password) {
        if (password.trim().equals("password"))
            return true;
        else return false;
    }

    public static int dpToPx(Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}
