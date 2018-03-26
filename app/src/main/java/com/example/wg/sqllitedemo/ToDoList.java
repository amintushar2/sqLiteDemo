package com.example.wg.sqllitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {


    ListView myList;
    ListAdapter adapter;
    ArrayList<ToDoModel> todolist;
    DatabaseHandler dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
    myList = findViewById(R.id.listView);
    dbh = new DatabaseHandler(ToDoList.this);
    todolist = dbh.selectall();
        adapter = new ListAdapter(ToDoList.this,todolist,R.layout.single_row);

        myList.setAdapter(adapter);
    }
}
