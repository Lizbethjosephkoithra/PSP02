package com.myapplicationdev.android.psp02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter {

    private ArrayList<Holiday> holidays;
    private Context context;
    private TextView tvHolidayName;
    private TextView tvHolidayDate;
    private ImageView ivPic;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvHolidayName =         rowView.findViewById(R.id.tvTitle);
        tvHolidayDate =             rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivPic =             rowView.findViewById(R.id.ivHoliday);



        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday = holidays.get(position);
        // Set the TextView to show the food

        tvHolidayName.setText(currentHoliday.getTitle());
        tvHolidayDate.setText(currentHoliday.getDate());

        // Set the image to star or nostar accordingly
        if(tvHolidayName.equals("New Year's Day")) {
            ivPic.setImageResource(R.drawable.new_year);
        }
        else if(tvHolidayName.equals("Labour Day")){
            ivPic.setImageResource(R.drawable.labour_day);
        }
        else if(tvHolidayName.equals("Good Friday")){
            ivPic.setImageResource(R.drawable.good_friday);
        }else {
            ivPic.setImageResource(R.drawable.national_day);
        }

        // Return the nicely done up View to the ListView
        return rowView;
    }

}
