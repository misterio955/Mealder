package com.example.ideo.mealder.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.Utils.CustomPagerAdapter;
import com.example.ideo.mealder.models.User;

public class OwnActivity extends Activity {

    private ViewPager viewPager;
    private User user;
    private Button homeButton;
    RelativeLayout layout;
    RelativeLayout transparent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own);
        viewPager = findViewById(R.id.viewPager);
        homeButton = findViewById(R.id.homeButton);
        layout = findViewById(R.id.layout);
        transparent = findViewById(R.id.transparent);
        user = HomeScreenActivity.getUsers().get(0);
        setClicks();
        if (user.getOwnMeals().size() == 0) {
            layout.setVisibility(View.GONE);
            transparent.setVisibility(View.VISIBLE);
        } else viewPager.setAdapter(new CustomPagerAdapter(this, user.getOwnMeals()));
    }

    private void setClicks() {
        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), HomeScreenActivity.class));
            }
        });
    }
}
