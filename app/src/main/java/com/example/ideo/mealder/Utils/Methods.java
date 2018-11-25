package com.example.ideo.mealder.Utils;

import android.content.Context;

import com.example.ideo.mealder.activities.HomeScreenActivity;
import com.example.ideo.mealder.models.User;

import java.util.List;

public class Methods {

    private static List<User> users= HomeScreenActivity.getUsers();

    public static boolean loginIsCorrect(String login) {
//        boolean isCorrect = false;
//        for (User user : users) {
//            if (login.trim().equals(user.getUserName())) {
//                isCorrect = true;
//                break;
//            }
//        }
//
//        return isCorrect;
    return true;
    }

    public static boolean passwordIsCorrect(String password) {
//        boolean isCorrect = false;
//        for (User user : users) {
//            if (password.trim().equals(user.getPassword())) {
//                isCorrect = true;
//                break;
//            }
//        }
//
//        return isCorrect;
        return true;
    }

    public static int dpToPx(Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    int reps = 100;

    public static void testRegexp(int reps) {
        for (int i = 0; i < reps; i++)
            ("ab4r3rgf" + i).matches("[a-zA-Z0-9]");
    }

    public static boolean isAlphanumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c) && !Character.isLetter(c))
                return false;
        }

        return true;
    }

    public boolean isAlphanumeric2(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a)
                return false;
        }
        return true;
    }
}
