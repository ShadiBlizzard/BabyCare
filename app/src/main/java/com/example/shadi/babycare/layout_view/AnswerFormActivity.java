package com.example.shadi.babycare.layout_view;

import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class AnswerFormActivity extends BaseActivity {

    private TextView receiver;
    private EditText message;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_answer_form, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(1).setChecked(true);
        super.setTitle("New message");

        receiver = findViewById(R.id.receiver);
        message = findViewById(R.id.formMessage);
        send = findViewById(R.id.send_message);
    }
}
