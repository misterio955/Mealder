package com.example.ideo.mealder.models;

import java.util.List;

public class MealRecipe {

    private int mealId;
    private String mealName;
    private List<String> mealIngredients;
    private List<String> recipeSteps;
    private String photoPath;

    public MealRecipe(int mealId, String mealName, List<String> recipeSteps, List<String> mealIngredients, String photoPath) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.recipeSteps = recipeSteps;
        this.mealIngredients = mealIngredients;
        this.photoPath = photoPath;
    }

    public int getMealId() {
        return mealId;
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
}
