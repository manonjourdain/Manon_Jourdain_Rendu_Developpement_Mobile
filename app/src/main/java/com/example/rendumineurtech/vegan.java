package com.example.rendumineurtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class vegan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegan);
    }
    public void home(View view) {
        startActivity(new Intent(this, fil_actualite.class));
    }
    public void click(View view) {
        startActivity(new Intent(this, coconut_pie.class));
    }
    public void add(View view) {
        startActivity(new Intent(this, listItemActivity.class));
    }
}
