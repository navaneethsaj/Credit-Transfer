package com.blazingapps.asus.credittransfer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter {


    private final Context context;
    private final SQLiteDatabase mydatabase;
    Cursor resultSet;
    Activity activity;

    public UserAdapter(Context context, int resource, SQLiteDatabase mydatabase, Activity activity) {
        super(context, resource);
        this.context = context;
        this.mydatabase = mydatabase;
        this.activity = activity;
        resultSet = mydatabase.rawQuery("Select * from User",null);
        resultSet.moveToFirst();
    }
    @Override
    public int getCount() {
        Cursor resultSet = mydatabase.rawQuery("Select * from User",null);
        return resultSet.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //convertView = inflater.inflate(R.layout.list_item, null);
        convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);

        final TextView name = convertView.findViewById(R.id.name);
        TextView email = convertView.findViewById(R.id.email);
        TextView credit = convertView.findViewById(R.id.credit);

        resultSet.moveToPosition(position);
        final String nametext = resultSet.getString(0);
        final String emailtext = resultSet.getString(1);
        final String credittext = resultSet.getString(2).toString();

        LinearLayout root = convertView.findViewById(R.id.root_item);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Act2.class);
                intent.putExtra("NAME",nametext);
                intent.putExtra("EMAIL",emailtext);
                intent.putExtra("CREDIT",credittext);
                context.startActivity(intent);

                activity.finish();
            }
        });
        name.setText(nametext);
        email.setText(emailtext);
        credit.setText(credittext);
        return convertView;
    }

}
