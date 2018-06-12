package com.example.shadi.babycare.layout_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class MessageFormActivity extends AppCompatActivity {

    private TextView receiver;
    private EditText message;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_form);
        this.setTitle("New message");

        receiver = findViewById(R.id.receiver);
        message = findViewById(R.id.formMessage);
        send = findViewById(R.id.send_message);
    }
}
