package com.blazingapps.asus.credittransfer;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase mydatabase = openOrCreateDatabase("DummyData",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS User(Username VARCHAR,Email VARCHAR, Credit VARCHAR);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Navaneeth', 'navaneethsaj@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Ram', 'ram@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Sita', 'sita@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Lakshman', 'lak@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Raavan', 'ravan@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Mohanlal', 'lal@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Rajnikanth', 'rajani@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Surya', 'surya@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Murugan', 'murugan@gmail.com', 100);");


        ListView listView = findViewById(R.id.list_view);
        UserAdapter adapter = new UserAdapter(this, R.layout.list_item, mydatabase, this);
        listView.setAdapter(adapter);
        this.adapter = adapter;
    }
    UserAdapter adapter;
    public void Notify(){
        adapter.notifyDataSetChanged();
    }
}
