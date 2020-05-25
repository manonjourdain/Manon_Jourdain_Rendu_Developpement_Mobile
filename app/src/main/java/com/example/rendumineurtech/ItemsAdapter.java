package com.example.rendumineurtech;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.rendumineurtech.models.Item;
import com.example.rendumineurtech.readers.ItemReaderDbHelper;


import java.util.ArrayList;

public class ItemsAdapter extends ArrayAdapter<Item> {
    Context context;

    public static final String EXTRA_MESSAGE = "MESSAGE";

    public ItemsAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Item item = getItem(position);
        Log.i("log position", ""+position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_view_list_item, parent, false);
        }
        // Lookup view for data population
        TextView item1 = convertView.findViewById(R.id.label);
        ImageButton deleteItem = convertView.findViewById(R.id.deleteItem);
        ImageButton editItem = convertView.findViewById(R.id.editItem);

        // Populate the data into the template view using the data object
        item1.setText(item.item);
        deleteItem.setTag(position);
        editItem.setTag(position);


        deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer position = (Integer) v.getTag();

                Item item = getItem(position);

                ItemReaderDbHelper dbHelper = new ItemReaderDbHelper(getContext());
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                db.delete(Item.TABLE_NAME, "_ID = " + item.id, null);

                remove(item);

                Log.i("Test Dev Mobile", ""+position);
            }
        });


        editItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer) v.getTag();
                Item item = getItem(position);
                Log.i("log item id", ""+item.id);
                Log.i("log item item", ""+item.item);

                Intent i = new Intent(context, ItemEditActivity.class);
                i.putExtra(EXTRA_MESSAGE, "" + item.id);
                context.startActivity(i);

                Log.i("Test Dev Mobile", ""+position);
            }
        });



        // Return the completed view to render on screen
        return convertView;
    }
}
