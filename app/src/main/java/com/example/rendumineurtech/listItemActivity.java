package com.example.rendumineurtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rendumineurtech.models.Item;
import com.example.rendumineurtech.readers.ItemReaderDbHelper;

import java.util.ArrayList;

public class listItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        //getSupportActionbar().SetDisplayHomeAsEnabled(true);

        ItemReaderDbHelper dbHelper = new ItemReaderDbHelper(getBaseContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        String[] projection = {
                Item._ID,
                Item.COLUMN_NAME_LABEL,
        };

        Cursor cursor = db.query(
                Item.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        // List items = new ArrayList<Item>();

        ArrayList<Item> items = new ArrayList<Item>();

        // Parcourir le cursor et l'affecter à un objet

        while (cursor.moveToNext()){
            Item item = new Item(
                    cursor.getLong(cursor.getColumnIndexOrThrow(Item._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(Item.COLUMN_NAME_LABEL))
            );
            items.add(item);
        }

        cursor.close();
        Log.i("My app", items.toString());


        ListView itemListView = findViewById( R.id.itemListView);
        //ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, items);
        //itemListView.setAdapter(listAdapter);

        ItemsAdapter iAdapter = new ItemsAdapter(this, items);
        itemListView.setAdapter(iAdapter);
        Log.i("My app", items.toString());


        //DELETE
        /*
        itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int label, long id) {
                Item item = (Item) items.get(label);
                Log.i("My app", ""+item.item);

                ItemReaderDbHelper dbHelper = new ItemReaderDbHelper(getBaseContext());
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                db.delete(Item.TABLE_NAME, "_ID = " + item.id, null);
                Log.i("My app", Long.toString(id));


                items.remove(label);
                iAdapter.notifyDataSetChanged();

            }
        });

         */

    }

    public void goToAddItem(View v){
        Intent i = new Intent(this, com.example.rendumineurtech.addItemActivity.class);
        startActivity(i);
    }

    public void home(View view) {
        startActivity(new Intent(this, fil_actualite.class));
    }
}
