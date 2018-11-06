package com.example.ideo.mealder.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.Utils.Methods;

public class SignInActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private Button signIn;
    private TextView registerNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.signIn);
        registerNow = findViewById(R.id.registerNow);
        setClicks();
        setLoginAndPass();
    }

    //To help
    private void setLoginAndPass(){
        login.setText("login");
        password.setText("password");
    }

    private void setClicks() {
        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Methods.loginIsCorrect(login.getText().toString()) &&
                        Methods.passwordIsCorrect(password.getText().toString())) {
                    startActivity(new Intent(getBaseContext(), HomeScreenActivity.class));
                } else {
                    Toast toast = Toast.makeText(getBaseContext(), "Invalid login or password", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        registerNow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SignUpActivity.class));
            }
        });
    }
}
