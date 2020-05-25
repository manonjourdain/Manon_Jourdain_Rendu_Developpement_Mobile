package com.example.rendumineurtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {

        startActivity(new Intent(this, Onboarding1.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Test Dev Mobile", "on Start");
        Toast.makeText(this, "Bienvenue", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Welcome back !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Test Dev Mobile", "Au revoir l'application");
    }

    /*public void goToListItem(View v) {
        Intent i = new Intent(this, listItemActivity.class);
        startActivity(i);
    }*/
}
