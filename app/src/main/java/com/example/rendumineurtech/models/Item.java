package com.example.rendumineurtech.models;


import android.provider.BaseColumns;

public class Item implements BaseColumns {
    public static final String TABLE_NAME = "item";
    public static final String COLUMN_NAME_LABEL = "label";

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," + COLUMN_NAME_LABEL + " TEXT)";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;


    //private final int item;
    //private final long id;

    public long id;
    public String item;


    public Item(long id, String item){
        this.id = id;
        this.item = item;
    }


    //public Item(int columnIndexOrThrow) {
    // }
}


