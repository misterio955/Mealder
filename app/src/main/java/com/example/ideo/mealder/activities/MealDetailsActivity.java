package com.example.ideo.mealder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.models.MealRecipe;

public class MealDetailsActivity extends Activity {

    private MealRecipe model;
    private TextView name;
    private TextView ingredients;
    private TextView recipeSteps;
    private ImageView photoPath;
    private TextView description;
    private TextView totalPrice;

    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);
        name = findViewById(R.id.mealName);
        ingredients = findViewById(R.id.mealIngredients);
        recipeSteps = findViewById(R.id.mealSteps);
        photoPath = findViewById(R.id.mealPhoto);
        description = findViewById(R.id.mealDescription);
        totalPrice = findViewById(R.id.mealPrice);
        homeButton = findViewById(R.id.homeButton);
        handleIntent();
        setLayoutValues();
        setClicks();
    }

    public void handleIntent() {
        model = (MealRecipe) getIntent().getSerializableExtra("recipe");
    }

    public void setLayoutValues() {
        name.setText(model.getMealName());
        ingredients.setText(model.getMealIngredients().toString());
        recipeSteps.setText(model.getRecipeSteps().toString());
        photoPath.setBackgroundResource(R.mipmap.ic_launcher);
        description.setText(model.getMealDescription());
        totalPrice.setText(String.valueOf(model.getTotalPrice()));
    }

    private void setClicks() {
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), HomeScreenActivity.class));
            }
        });
    }
}
