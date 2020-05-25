package com.example.rendumineurtech;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rendumineurtech.models.Item;
import com.example.rendumineurtech.readers.ItemReaderDbHelper;



public class ItemEditActivity extends AppCompatActivity {

    public Item item = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_edit);

        Intent intent = getIntent();
        String id =  intent.getStringExtra(ItemsAdapter.EXTRA_MESSAGE);
        Log.i("verifier", id);

        ItemReaderDbHelper dbHelper = new ItemReaderDbHelper(getBaseContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection = Item._ID + " = ?";
        String[] selectionArgs = { id };
        Cursor cursor = db.query(
                Item.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        while(cursor.moveToNext()) {
            item = new Item(
                    cursor.getLong(cursor.getColumnIndexOrThrow(Item._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(Item.COLUMN_NAME_LABEL))
            );
        }

        EditText itemValueEditText = (EditText) findViewById(R.id.editItemLabel);
        itemValueEditText.setText(""+ item.item);
    }

    public void updateItem(View v) {
        EditText itemValueEditText = findViewById(R.id.editItemLabel);
        Log.i("My app", itemValueEditText.getText().toString());

        ItemReaderDbHelper dbHelper = new ItemReaderDbHelper(getBaseContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Item.COLUMN_NAME_LABEL, itemValueEditText.getText().toString());

        String selection = Item._ID + " = ?";
        String[] selectionArgs = { ""+ item.id};

        int count = db.update(
                Item.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

        itemValueEditText.setText("");

        Toast.makeText(this, "Item mis à jour !", Toast.LENGTH_LONG).show();

        Intent i = new Intent(this, listItemActivity.class);
        startActivity(i);
    }
}