package com.example.shadi.babycare.layout_view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.shadi.babycare.R;
import com.google.android.gms.maps.MapView;


public class SearchingActivity extends AppCompatActivity {

    private MapView map;
    private EditText calendar;
    private EditText timer1;
    private EditText timer2;
    private Calendar mCurrentDate;
    private TimePickerDialog tpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        calendar = findViewById(R.id.calendarview);
        timer1 = findViewById(R.id.timeview);
        timer2 = findViewById(R.id.timeview2);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int year = mCurrentDate.get(Calendar.YEAR);
                int month = mCurrentDate.get(Calendar.MONTH);
                int day = mCurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SearchingActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.setText(dayOfMonth+"-"+month+"-"+year);
                        mCurrentDate.set(year, month, dayOfMonth);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        /*timer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int startingHour = mCurrentDate.get(Calendar.HOUR_OF_DAY);
                int startingMinute = mCurrentDate.get(Calendar.MINUTE);

                tpd = new TimePickerDialog(SearchingActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        timer1.setText(hourOfDay+':'+minute);
                    }
                }, startingHour, startingMinute, true);

            }
        });*/

    }

}
