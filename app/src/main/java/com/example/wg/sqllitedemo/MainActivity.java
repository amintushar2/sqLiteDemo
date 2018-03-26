package com.example.wg.sqllitedemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText title , content;

    Button save;
    DatabaseHandler dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
       title=findViewById(R.id.tttt);
       content=findViewById(R.id.yyy);
       save=findViewById(R.id.saveBtn);
        dbh= new DatabaseHandler(MainActivity.this);
save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String titleText =title.getText().toString();
        String contentText = content.getText().toString();
        long date=  System.currentTimeMillis();
        ToDoModel todo = new ToDoModel();
        todo.setTitle(titleText);
        todo.setContent(contentText);
        todo.setDate(date);
        dbh.insertData(todo);
        Intent intent = new Intent(MainActivity.this,ToDoList.class);
        startActivity(intent);
    }



    });
    }
}
