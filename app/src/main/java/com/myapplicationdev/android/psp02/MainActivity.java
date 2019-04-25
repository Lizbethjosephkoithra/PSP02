package com.myapplicationdev.android.psp02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCategory;
    ArrayAdapter aaCategory;
    ArrayList<String> alCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCategory = this.findViewById(R.id.lvCat);
        final ArrayList<String> alCategory = new ArrayList() ;
        alCategory.add("Secular");
        alCategory.add("Ethnic & Religion");

        ArrayAdapter<String> aaCategory = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alCategory);
        lvCategory.setAdapter(aaCategory);

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String category = alCategory.get(position);

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("category",category);
                startActivity(intent);

            }
        });
    }
}
