package com.example.ideo.mealder.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.Utils.CustomPagerAdapter;
import com.example.ideo.mealder.models.MealRecipe;

import java.util.List;

public class MealBrowser extends AppCompatActivity {

    private ViewPager viewPager;
    private List<MealRecipe> mealRecipes;
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_browser);
        viewPager = findViewById(R.id.viewPager);
        homeButton = findViewById(R.id.homeButton);
        mealRecipes = HomeScreenActivity.getMealRecipes();
        setClicks();
        if (mealRecipes.size() == 0) {
            //pusty
        } else viewPager.setAdapter(new CustomPagerAdapter(this, mealRecipes));
    }

    private void setClicks() {
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), HomeScreenActivity.class));
            }
        });
    }
}
