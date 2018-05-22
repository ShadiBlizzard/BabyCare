package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class Register2Activity extends AppCompatActivity {

    private String email, password, role;
    private EditText edit1, edit2, edit3, edit4, edit5;
    private TextView errorText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");
        role = intent.getStringExtra("role");
        edit1 = findViewById(R.id.name);
        edit2 = findViewById(R.id.surname);
        edit3 = findViewById(R.id.idNumber);
        edit4 = findViewById(R.id.ssn);
        edit5 = findViewById(R.id.phone);
        errorText = findViewById(R.id.errorregister2);
    }

    public void onGoOn2 (View view) {
        Intent intent = new Intent(this, Register3Activity.class);
        String name = edit1.getText().toString();
        String surname = edit2.getText().toString();
        String idNumber = edit3.getText().toString();
        String ssn = edit4.getText().toString();
        String phone = edit5.getText().toString();

        if (name == null || surname==null || idNumber ==null || ssn==null || phone == null)
            errorText.setText("All fields must be filled!");
        else {
            intent.putExtra("name", name);
            intent.putExtra("surname", name);
            intent.putExtra("idNumber", idNumber);
            intent.putExtra("ssn", ssn);
            intent.putExtra("phone", phone);
            startActivity(intent);
        }
    }
}
