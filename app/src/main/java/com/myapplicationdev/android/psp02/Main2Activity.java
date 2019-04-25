package com.myapplicationdev.android.psp02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ListView lv;
    TextView tv;
    ArrayAdapter aa;
    ArrayList<Holiday> holidays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = this.findViewById(R.id.textView2);
        lv = this.findViewById(R.id.lvCat2);

        Intent intent  = getIntent();
        String category = intent.getStringExtra("category");
        tv.setText(category);

        // Create a few food objects in Food array
        holidays = new ArrayList<Holiday>();

        if(category.equals("Secular")){
            holidays.add(new Holiday("New Year's Day","1 Jan 2017" ));
            holidays.add(new Holiday("Labour Day","1 May 2017" ));
        }
        else{
            holidays.add(new Holiday("Good Friday","19 April 2019" ));
            holidays.add(new Holiday("National Day","9 August 2019" ));
        }


        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new HolidayAdapter(this, R.layout.row, holidays);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = holidays.get(position);

                Toast.makeText(Main2Activity.this, selectedHoliday.getTitle()
                                + " Date: " + selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    }

