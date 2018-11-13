package com.example.ideo.mealder.models;

import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private List<MealRecipe> favouriteMeals;
    private List<MealRecipe> ownMeals;


    public User(int userId, String userName, String password, String email, List<MealRecipe> favouriteMeals, List<MealRecipe> ownMeals) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.favouriteMeals = favouriteMeals;
        this.ownMeals = ownMeals;
    }

    public String getEmail() {
        return email;
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
