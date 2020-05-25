package com.example.rendumineurtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class fil_actualite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fil_actualite);
    }
    public void clickView(View view) {
        Intent i = new Intent(this, vegan.class);
        startActivity(i);
    }

    public void home(View view) {
        Intent i = new Intent(this, fil_actualite.class);
        startActivity(i);
    }


    public void click(View view) {
        Intent i = new Intent(this, listItemActivity.class);
        startActivity(i);
    }

}
