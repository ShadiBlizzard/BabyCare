package com.example.shadi.babycare.layout_view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.shadi.babycare.R;
import com.google.android.gms.maps.MapView;


public class SearchingActivity extends AppCompatActivity {

    private MapView map;
    private EditText calendar;
    private EditText timer1;
    private EditText timer2;
    private Calendar mCurrentDate;
    private Button search;
    private int yearChosen, monthChosen, dayChosen, startingHourChosen, endingHourChosen, startingMinuteChosen, endingMinuteChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);

        calendar = findViewById(R.id.calendarview);
        timer1 = findViewById(R.id.timeview);
        timer2 = findViewById(R.id.timeview2);
        initialize();

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int year = mCurrentDate.get(Calendar.YEAR);
                int month = mCurrentDate.get(Calendar.MONTH);
                int day = mCurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SearchingActivity.this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.setText(dayOfMonth+"-"+month+"-"+year);
                        mCurrentDate.set(year, month, dayOfMonth);
                        yearChosen = year;
                        monthChosen = month;
                        dayChosen = dayOfMonth;

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        timer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int startingHour = mCurrentDate.get(Calendar.HOUR_OF_DAY);
                int startingMinute = mCurrentDate.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(SearchingActivity.this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        timer1.setText(hourOfDay+':'+minute);
                        startingHourChosen = hourOfDay;
                        startingMinuteChosen = minute;
                    }
                }, startingHour, startingMinute, true);
                tpd.show();

            }
        });

        timer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int endingHour = mCurrentDate.get(Calendar.HOUR_OF_DAY);
                int endingMinute = mCurrentDate.get(Calendar.MINUTE);

                TimePickerDialog tpd2 = new TimePickerDialog(SearchingActivity.this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        timer2.setText(hourOfDay+':'+minute);
                        endingHourChosen = hourOfDay;
                        endingMinuteChosen = minute;
                    }
                }, endingHour, endingMinute, true);
                tpd2.show();

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateTimeParametersConstraints();
                //TODO robe da mandare al backend
            }
        });

    }

    private void initialize() {
        dayChosen = -1;
        startingHourChosen = -1;
        endingHourChosen = -1;
    }

    private void dateTimeParametersConstraints() {
        if(dayChosen ==-1 || startingHourChosen ==-1 || endingHourChosen ==-1) {
            Toast t = Toast.makeText(this, "you must fill all the parameters", Toast.LENGTH_SHORT);
            t.show();
        }

        if(startingHourChosen == endingHourChosen) {
            if (startingMinuteChosen >= endingHourChosen)
                timer1.setError("set correct time space");
        }
        else if (startingHourChosen >= endingHourChosen)
            timer1.setError("set correct time space");



    }

}
