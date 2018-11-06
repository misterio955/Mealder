package com.example.ideo.mealder.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.example.ideo.mealder.R;

public class SignUpActivity extends Activity {

    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUp = findViewById(R.id.signUp);
        setClicks();
    }

    private void setClicks() {
        signUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SignInActivity.class));
            }
        });
    }
}
