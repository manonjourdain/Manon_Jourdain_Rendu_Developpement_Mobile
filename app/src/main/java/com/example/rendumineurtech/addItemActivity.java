package com.example.rendumineurtech;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rendumineurtech.models.Item;
import com.example.rendumineurtech.readers.ItemReaderDbHelper;

public class addItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void saveItem(View v){
        EditText itemLabel = findViewById(R.id.itemLabel);
        Log.i("Test Dev Mobile", itemLabel.getText().toString());

        ItemReaderDbHelper dbHelper = new ItemReaderDbHelper(getBaseContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Item.COLUMN_NAME_LABEL, itemLabel.getText().toString());

        long newRowId = db.insert(Item.TABLE_NAME, null, values);
        Log.i("Test Dev Mobile", "" + newRowId);

        itemLabel.setText("");


        Toast.makeText(this, "Item ajouté!", Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, listItemActivity.class);
        startActivity(i);
    }
}
