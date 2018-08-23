package com.example.shadi.babycare.layout_view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SetAvailabilityActivity extends BaseActivity {

    private MaterialCalendarView calendar;
    private int year, month, day;
    private Button send;
    private Map<CheckBox, Boolean> hours = new LinkedHashMap<>();
    private CheckBox predefined;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_set_availability, fl);
        super.setTitle("Add availability");

        calendar.state().edit()
                .setMinimumDate(new Date())
                .commit();

        calendar = findViewById(R.id.set_calendar);

        //checkbox handler
        predefined= findViewById(R.id.period_pred1);

        hours.put((CheckBox)findViewById(R.id.period1), false);
        hours.put((CheckBox)findViewById(R.id.period2), false);
        hours.put((CheckBox)findViewById(R.id.period3), false);
        hours.put((CheckBox)findViewById(R.id.period4), false);
        hours.put((CheckBox)findViewById(R.id.period5), false);
        hours.put((CheckBox)findViewById(R.id.period6), false);
        hours.put((CheckBox)findViewById(R.id.period7), false);
        hours.put((CheckBox)findViewById(R.id.period8), false);
        hours.put((CheckBox)findViewById(R.id.period9), false);
        hours.put((CheckBox)findViewById(R.id.period10), false);
        hours.put((CheckBox)findViewById(R.id.period11), false);
        hours.put((CheckBox)findViewById(R.id.period12), false);
        hours.put((CheckBox)findViewById(R.id.period13), false);
        hours.put((CheckBox)findViewById(R.id.period14), false);
        hours.put((CheckBox)findViewById(R.id.period15), false);
        hours.put((CheckBox)findViewById(R.id.period16), false);
        hours.put((CheckBox)findViewById(R.id.period17), false);
        hours.put((CheckBox)findViewById(R.id.period18), false);
        hours.put((CheckBox)findViewById(R.id.period19), false);
        hours.put((CheckBox)findViewById(R.id.period20), false);
        hours.put((CheckBox)findViewById(R.id.period21), false);
        hours.put((CheckBox)findViewById(R.id.period22), false);
        hours.put((CheckBox)findViewById(R.id.period23), false);
        hours.put((CheckBox)findViewById(R.id.period24), false);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                periodHandler();
            }
        });
        calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected( MaterialCalendarView materialCalendarView, CalendarDay calendarDay, boolean b) {

                year = calendarDay.getYear();
                month = calendarDay.getMonth();
                day = calendarDay.getDay();
                send = findViewById(R.id.send_avail);


            }
        });

    }

    private void periodHandler() {
        List<CheckBox> keyList = new ArrayList<>(hours.keySet());
        //I set the hashmap value to true if the corresponding key checkbox is checked
        for (int i=0; i<hours.size(); i++) {
            CheckBox key = keyList.get(i);
            if(key.isChecked())
                hours.put(key, true);
        }

        //FIRST: I check the predefined period
        if (predefined.isChecked()) {
            sendAvailability(0, 24);
            hours.clear();
        }

        //SECOND: I check all the hourly periods

        //now I cast two temporary values for periods
        int tempStart = -1, tempEnd;
        for (int i = 0; i<hours.size(); i++) {
            //initialize the period, I start from the first checked checkbox
            if(hours.get(keyList.get(i))) {
                if(tempStart==-1)
                    tempStart = i;
                //if it is checked and I'm not in the last checkbox
                if(i<hours.size()-1) {
                    //if the following checkbox is checked, update the end time to that of the following
                    if (!hours.get(keyList.get(i + 1))) {
                        tempEnd = i + 1;
                        sendAvailability(tempStart, tempEnd);
                        tempStart = -1;
                    }
                }
                //if I'm in the last, no need to perform other checkings
                else {
                    tempEnd = i+1;
                    sendAvailability(tempStart, tempEnd);
                }

            }
        }


    }



    private void sendAvailability(int start, int end) {
        //TODO DEVO FINIRE LA GESTIONE DELL'INPUT
    }
}
