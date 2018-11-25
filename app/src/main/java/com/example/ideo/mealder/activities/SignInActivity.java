package com.example.ideo.mealder.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.Utils.Methods;
import com.example.ideo.mealder.models.User;

import java.util.List;

public class SignInActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private Button signIn;
    private TextView registerNow;
    SharedPreferences sharedPreferences;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeScreenActivity.setExamples();
        setContentView(R.layout.activity_sign_in);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.signIn);
        registerNow = findViewById(R.id.registerNow);
        users = HomeScreenActivity.getUsers();
        setClicks();
        setLoginAndPass();
    }

    //To help
    private void setLoginAndPass() {
        login.setText("login");
        password.setText("password");
    }

    private boolean logIn(String userName) {
        User findedUser = null;
        boolean isCorrect = false;
        for (User user : users) {
            if (user.getUserName().equals(userName.trim())) {
                findedUser = user;
                isCorrect = true;
                break;
            }
        }

        if (isCorrect) {
            sharedPreferences = getSharedPreferences("AppConfig", Context.MODE_PRIVATE);
            sharedPreferences.edit()
                    .putString("userName", findedUser.getUserName())
                    .putString("userPassword", findedUser.getPassword())
                    .putInt("userId", findedUser.getUserId())
                    .putBoolean("isLogged", true)
                    .apply();
        }
        return isCorrect;
    }

    private void setClicks() {
        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String userName = login.getText().toString();
                if (logIn(userName) &&
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
