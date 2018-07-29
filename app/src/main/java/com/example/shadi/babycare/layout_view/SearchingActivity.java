package com.example.shadi.babycare.layout_view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.shadi.babycare.R;
import com.google.android.gms.maps.MapView;

import java.util.Calendar;


public class SearchingActivity extends BaseActivity {

    private MapView map;
    private EditText calendar;
    private EditText timer1;
    private EditText timer2;
    private Calendar mCurrentDate, mCurrentTime;
    private Button search;
    private int yearChosen, monthChosen, dayChosen, startingHourChosen, endingHourChosen, startingMinuteChosen, endingMinuteChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_searching, fl);

        super.setTitle("Find a babysitter");

        calendar = findViewById(R.id.calendarview);
        timer1 = findViewById(R.id.timeview);
        timer2 = findViewById(R.id.timeview2);
        search = findViewById(R.id.search);
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
                        month++;
                        calendar.setText(dayOfMonth+" - "+ month +" - "+year);
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
                mCurrentTime = Calendar.getInstance();
                int startingHour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int startingMinute = mCurrentTime.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(SearchingActivity.this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        timer1.setText(hourOfDay+":"+String.format("%02d", minute));
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

                        timer2.setText(hourOfDay+":"+String.format("%02d", minute));
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

        else if(startingHourChosen == endingHourChosen) {
            if (startingMinuteChosen >= endingMinuteChosen) {
                timer1.setError("set correct time space");
                Toast t = Toast.makeText(this, "set correct time space", Toast.LENGTH_SHORT);
                t.show();
            }
        }
        else if (startingHourChosen >= endingHourChosen) {
            timer1.setError("set correct time space");
            Toast t = Toast.makeText(this, "set correct time space", Toast.LENGTH_SHORT);
            t.show();
        }



    }

}
