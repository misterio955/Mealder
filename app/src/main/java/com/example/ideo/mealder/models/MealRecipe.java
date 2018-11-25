package com.example.ideo.mealder.models;

import java.io.Serializable;
import java.util.List;

public class MealRecipe implements Serializable {

    private int mealId;
    private User userId;
    private String mealName;
    private List<String> mealIngredients;
    private List<String> recipeSteps;
    private String photoPath;
    private String mealDescription;
    private double totalPrice;

    public MealRecipe(int mealId, User userId, String mealName, List<String> recipeSteps, List<String> mealIngredients, String photoPath, String mealDescription, double totalPrice) {
        this.mealId = mealId;
        this.userId =  userId;
        this.mealName = mealName;
        this.recipeSteps = recipeSteps;
        this.mealIngredients = mealIngredients;
        this.photoPath = photoPath;
        this.mealDescription = mealDescription;
        this.totalPrice = totalPrice;
    }

    public int getMealId() {
        return mealId;
    }

    public User getUserId() {
        return userId;
    }

    public String getMealName() {
        return mealName;
    }

    public List<String> getRecipeSteps() {
        return recipeSteps;
    }

    public List<String> getMealIngredients() {
        return mealIngredients;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
