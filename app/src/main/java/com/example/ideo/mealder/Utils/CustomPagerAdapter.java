package com.example.ideo.mealder.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.models.MealRecipe;

import java.util.List;

public class CustomPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<MealRecipe> mealRecipes;
    private TextView mealName;
    private TextView mealIngredients;
    private TextView mealSteps;

    public CustomPagerAdapter(Context context, List<MealRecipe> recipes) {
        mContext = context;
        mealRecipes = recipes;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        View layout = mInflater.inflate(R.layout.view_pager_item, collection, false);
        collection.addView(layout);
        mealName = layout.findViewById(R.id.mealName);
        mealIngredients = layout.findViewById(R.id.mealIngredients);
        mealSteps = layout.findViewById(R.id.mealSteps);
        setTextValues(position);
        return layout;
    }

    private void setTextValues(int position) {
        MealRecipe recipe = mealRecipes.get(position);

        mealName.setText(recipe.getMealName());
        mealIngredients.setText(recipe.getMealIngredients().toString());
        mealSteps.setText(recipe.getRecipeSteps().toString());
    }

    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return mealRecipes.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
