package com.example.wg.sqllitedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by WG on 3/20/2018.
 */

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<ToDoModel> todolist;
    int resourse;

    public ListAdapter(Context context, ArrayList<ToDoModel> todolist, int resourse) {
        this.context = context;
        this.todolist = todolist;
        this.resourse = resourse;
    }

    @Override
    public int getCount() {
        return todolist.size();
    }

    @Override
    public ToDoModel getItem(int position) {
        return todolist.get(position);
    }




    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(resourse,parent,false);
        TextView title = row.findViewById(R.id.title1);
        TextView desc = row.findViewById(R.id.description1);
        TextView date = row.findViewById(R.id.date1);
        ToDoModel todo = getItem(position);
        title.setText(todo.getTitle());
        desc.setText(todo.getContent());

        Date df =new java.util.Date(todo.getDate());
        String vv=  new String("MM DD, YYY ").format(String.valueOf(df));
        date.setText(vv);

        return row;


    }
}
