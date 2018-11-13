package com.example.ideo.mealder.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.Utils.Methods;
import com.example.ideo.mealder.Utils.PaddingDecoration;
import com.example.ideo.mealder.Utils.RecyclerListAdapter;
import com.example.ideo.mealder.models.MealRecipe;
import com.example.ideo.mealder.models.User;

import java.util.ArrayList;
import java.util.List;

public class MealRecyclerActivity extends Activity {

    private List<MealRecipe> recipes = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private RecyclerListAdapter mealListAdapter = null;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_recycler);
        recipes = HomeScreenActivity.getMealRecipes();
        users = HomeScreenActivity.getUsers();
        setMealRecipeList();
        if (recipes.size() == 0) {
            //pusty
        }
    }

    private void setMealRecipeList() {
        RecyclerView mealRecipesList = findViewById(R.id.mealRecyclerList);
        mealRecipesList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mealRecipesList.setAdapter(mealListAdapter = new RecyclerListAdapter(recipes, users));
        mealRecipesList.addItemDecoration(new PaddingDecoration(Methods.dpToPx(getApplicationContext(), 20), PaddingDecoration.Type.Top, PaddingDecoration.Type.Bottom));
        mealListAdapter.setOnItemClickListener(new RecyclerListAdapter.MyClickListener() {
            @Override
            public void onEventClick(int position) {
                intent = new Intent(getBaseContext(), MealDetailsActivity.class);
                intent.putExtra("recipe", recipes.get(position));
                startActivity(intent);
            }
        }, getBaseContext());
    }
}
