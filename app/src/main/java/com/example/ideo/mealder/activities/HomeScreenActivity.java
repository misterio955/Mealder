package com.example.ideo.mealder.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.models.MealRecipe;

import java.util.ArrayList;
import java.util.List;

public class HomeScreenActivity extends AppCompatActivity {

    private static List<MealRecipe> mealRecipes = new ArrayList<>();
    private Button browserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        browserButton = findViewById(R.id.browserButton);
        setClicks();
        setExamples();
    }

    private void setExamples(){
        List<String> ingrets = new ArrayList<>();
        List<String> steps = new ArrayList<>();
        ingrets.add("skladnik1");
        ingrets.add("skladnik2");
        steps.add("krok1");
        steps.add("krok2");
        mealRecipes.add(new MealRecipe(0,"meal1", steps,ingrets,"path1"));
        mealRecipes.add(new MealRecipe(1,"meal2", steps,ingrets,"path2"));
        mealRecipes.add(new MealRecipe(2,"meal3", steps,ingrets,"path3"));
    }

    public static List<MealRecipe> getMealRecipes() {
        return mealRecipes;
    }

    private void setClicks() {
        browserButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MealBrowser.class));
            }
        });
    }
}