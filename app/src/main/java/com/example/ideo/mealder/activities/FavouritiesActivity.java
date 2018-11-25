package com.example.ideo.mealder.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.Utils.CustomPagerAdapter;
import com.example.ideo.mealder.models.User;

public class FavouritiesActivity extends Activity {

    private ViewPager viewPager;
    private User user;
    private Button homeButton;
    RelativeLayout layout;
    RelativeLayout transparent;
    Intent intent;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourities);
        viewPager = findViewById(R.id.viewPager);
        homeButton = findViewById(R.id.homeButton);
        layout = findViewById(R.id.layout);
        transparent = findViewById(R.id.transparent);
        sharedPreferences = getSharedPreferences("AppConfig", Context.MODE_PRIVATE);
        user = HomeScreenActivity.getUser(sharedPreferences.getInt("userId", 0));
        Log.e("aaa", "favourit:" + user.getUserId());
        setClicks();
        if (user.getFavouriteMeals().size() == 0) {
            layout.setVisibility(View.GONE);
            transparent.setVisibility(View.VISIBLE);
        } else
            viewPager.setAdapter(new CustomPagerAdapter(this, user.getFavouriteMeals(), new View.OnClickListener() {
                public void onClick(View v) {
                    intent = new Intent(getBaseContext(), MealDetailsActivity.class);
                    intent.putExtra("recipe", user.getFavouriteMeals().get(viewPager.getCurrentItem()));
                    startActivity(intent);
                }
            }));
    }

    private void setClicks() {
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), HomeScreenActivity.class));
            }
        });
    }
}
