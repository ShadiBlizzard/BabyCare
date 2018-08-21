package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetAvailabilityHourActivity extends BaseActivity {

    private int year, month, day;
    private Button send;
    private Map<CheckBox, Boolean> hours = new HashMap<>();
    private List<CheckBox>predefined = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_set_availability_hour, fl);

        Intent intent = getIntent();
        year = intent.getIntExtra("year", 0);
        month = intent.getIntExtra("month", 0);
        day = intent.getIntExtra("day", 0);
        send = findViewById(R.id.send_avail);

        //checkbox handler
        predefined.add((CheckBox) findViewById(R.id.period_pred1));
        predefined.add((CheckBox) findViewById(R.id.period_pred2));
        predefined.add((CheckBox) findViewById(R.id.period_pred3));
        predefined.add((CheckBox) findViewById(R.id.period_pred4));

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

        super.setTitle("Choose times");


    }

    private void periodHandler() {
        int startingHourPred, endingHourPred;

        //FIRST: I check all the predefined periods
        if (predefined.get(0).isChecked()) {
             sendAvailability(0, 24);
        }
        else {
            List<CheckBox> checked = new ArrayList<>();
            for (int i = 1; i<predefined.size(); i++) {
                if (predefined.get(i).isChecked())
                    checked.add(predefined.get(i));
            }

            switch (checked.size()) {
                case 1:
                    if(checked.get(0).getId() == predefined.get(1).getId()) {
                        startingHourPred = 8;
                        endingHourPred = 13;
                    }
                    else if(checked.get(0).getId() == predefined.get(2).getId()) {
                        startingHourPred = 13;
                        endingHourPred = 18;
                    }
                    else {
                        startingHourPred = 18;
                        endingHourPred= 24;
                    }

                    break;
                case 2:
                    //if the user select morning and evening, I have to create two distinct availabilities
                    if (checked.get(0).getId() == predefined.get(1).getId() && checked.get(1).getId() == predefined.get(3).getId()) {
                        sendAvailability(8, 13);
                        sendAvailability(18, 24);
                    }
                    //hours are in order, so if the first is morning, and we are not in the case above, the second
                    //is afternoon
                    else if(checked.get(0).getId() == predefined.get(1).getId()) {
                        sendAvailability(8, 18);
                    }
                    //afternoon-evening case
                    else
                        sendAvailability(13, 24);
                    break;
                    //foolproof case
                case 3:
                    sendAvailability(0, 24);
                    break;
                default:
                    break;
            }

        }

    }

    private void sendAvailability(int start, int end) {
        //TODO DEVO FINIRE LA GESTIONE DELL'INPUT
    }

}
