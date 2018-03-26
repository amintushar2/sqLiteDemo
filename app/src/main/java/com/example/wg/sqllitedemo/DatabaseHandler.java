package com.example.wg.sqllitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DatabaseHandler extends SQLiteOpenHelper {
    ArrayList<ToDoModel> myList =new ArrayList<>();
    String title,description;
    long date;

    public DatabaseHandler(Context context) {
        super(context, DB_Constants.DATABASE_NAME, null, DB_Constants.DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        final String CREATE_TABLE ="CREATE TABLE "
                +ToDo_Constants.TABLE_NAME +" ("
                +ToDo_Constants.CONTENT_ID + " int primary key, "
                +ToDo_Constants.CONTENT_NAME + " varchar(255), "
                +ToDo_Constants.CONTENT_DESC+" varchar(255), "
                +ToDo_Constants.CONTENT_DATE+" long); ";

             db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            final  String DROP_TABLE = "DROP TABLE IF EXISTS " +ToDo_Constants.TABLE_NAME+ ";";
           onCreate(db);
    }

    public void insertData(ToDoModel todo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ToDo_Constants.CONTENT_NAME,todo.getTitle());
        values.put(ToDo_Constants.CONTENT_DESC,todo.getContent());
        values.put(ToDo_Constants.CONTENT_DATE,todo.getDate());
        db.insert(ToDo_Constants.TABLE_NAME,null,values);

        Log.d("INSERT","DATA HAS INSERTED");
    }
    public  ArrayList<ToDoModel> selectall() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(ToDo_Constants.TABLE_NAME, new String[]{ToDo_Constants.CONTENT_NAME, ToDo_Constants.CONTENT_DESC, ToDo_Constants.CONTENT_DATE}, null, null, null, null,
                ToDo_Constants.CONTENT_DATE + " DESC");
        if (cursor.moveToFirst()){
            do {
                title = cursor.getString(cursor.getColumnIndex(ToDo_Constants.CONTENT_NAME));
                description = cursor.getString(cursor.getColumnIndex(ToDo_Constants.CONTENT_DESC));
                date = cursor.getLong(cursor.getColumnIndex(ToDo_Constants.CONTENT_DATE));
                ToDoModel todo = new ToDoModel();
                todo.setTitle(title);
                todo.setContent(description);
                todo.setDate(date);
                myList.add(todo);
            } while (cursor.moveToNext());
    }
        return myList;
    }

}
