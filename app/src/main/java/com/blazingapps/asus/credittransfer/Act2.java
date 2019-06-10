package com.blazingapps.asus.credittransfer;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);

        String[] emails = {"navaneethsaj@gmail.com","ram@gmail.com","sita@gmail.com","lak@gmail.com","ravan@gmail.com","lal@gmail.com","rajani@gmail.com"
        ,"surya@gmail.com","murugan@gmail.com"};
//        mydatabase.execSQL("INSERT INTO User VALUES('Navaneeth', 'navaneethsaj@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Ram', 'ram@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Sita', 'sita@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Lakshman', 'lak@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Raavan', 'ravan@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Mohanlal', 'lal@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Rajnikanth', 'rajani@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Surya', 'surya@gmail.com', 100);");
//        mydatabase.execSQL("INSERT INTO User VALUES('Murugan', 'murugan@gmail.com', 100);");

        Intent intent = getIntent();
        String namestring  = intent.getStringExtra("NAME");
        final String emailstring  = intent.getStringExtra("EMAIL");
        final String creditstring = intent.getStringExtra("CREDIT");
        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,
                emails);
        spinner.setAdapter(adapter);

        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        TextView credit = findViewById(R.id.credit);
        final EditText editText = findViewById(R.id.input);
        Button button = findViewById(R.id.button);
        name.setText(namestring);
        email.setText(emailstring);
        credit.setText(creditstring);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().length() <=0 ){
                    return;
                }
                if (Integer.valueOf(creditstring) - Integer.valueOf(editText.getText().toString()) < 0){
                    Toast.makeText(getApplicationContext(),"NO AMOUNT",Toast.LENGTH_LONG).show();
                    return;
                }

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UPDATE User SET Credit = ");
                stringBuilder.append(Integer.valueOf(creditstring) - Integer.valueOf(editText.getText().toString()));
                stringBuilder.append(" WHERE EMAIL = '");
                stringBuilder.append(emailstring);
                stringBuilder.append("';");

                SQLiteDatabase mydatabase = openOrCreateDatabase("DummyData",MODE_PRIVATE,null);
                mydatabase.execSQL(stringBuilder.toString());

                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("UPDATE User SET Credit = Credit + ");
                stringBuilder2.append(Integer.valueOf(editText.getText().toString()));
                stringBuilder2.append(" WHERE EMAIL = '");
                stringBuilder2.append(spinner.getSelectedItem().toString());
                stringBuilder2.append("';");
                mydatabase.execSQL(stringBuilder2.toString());

                onBackPressed();
                Toast.makeText(getApplicationContext(),"Transfered",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
