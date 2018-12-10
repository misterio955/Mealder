package com.example.ideo.mealder.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.models.MealRecipe;

public class AddMeal extends AppCompatActivity {
    private static final int RESULT_LOAD_IMG = 20;
    private ImageView image_view;
    private Uri imageUri;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        image_view = findViewById(R.id.imageView);

    }

    //Wyświetlenie galerii
    public void galleryButtonOnClick(View v) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
    }

    //Wybranie zdjecia
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            try {
                imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                image_view.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }
    //Tworzenie i wysyłanie posiłku do bazy
    public void addMeal(View v) {
        //Utworzenie posiłku
        MealRecipe meal = new MealRecipe(
                10,
                null,
                findViewById(R.id.NameMealText).toString(),
                stringToList(findViewById(R.id.HowMakeMealText).toString()),
                stringToList(findViewById(R.id.MealRecipeText).toString()),
                imageUri.getPath(),
                findViewById(R.id.MealInformationText).toString(),
                Double.parseDouble(findViewById(R.id.MealPriceText).toString())
        );
        //Wysłanie posiłku do bazy
    }

    //findViewById(R.id.MealRecipeText);
    private List<String> stringToList(String text) {
        //Zmiana string na liste
        list.clear();
        for (String tab : text.split("\n")) {
            list.add(tab);
        }
        return list;
    }

}

