package com.example.ideo.mealder.models;

import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String password;
    private List<MealRecipe> favouriteMeals;

    public User(int userId, String userName, String password, List<MealRecipe> favouriteMeals) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.favouriteMeals = favouriteMeals;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<MealRecipe> getFavouriteMeals() {
        return favouriteMeals;
    }
}
