package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class Register1Activity extends AppCompatActivity {

    private EditText edit1, edit2, edit3;
    private RadioGroup radioGroup;
    private RadioButton radio1;
    private TextView errorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit1 = findViewById(R.id.emailreg);
        edit2 = findViewById(R.id.passwordreg);
        edit3 = findViewById(R.id.password2reg);
        radioGroup = findViewById(R.id.radioGroup);
        errorMsg = findViewById(R.id.errorregister);
    }

    /**
     * here I get all the parameters inserted by the user, and I check
     * if they're correctly written
     * @param view
     */
    public void onGoOn(View view) {

        Intent intent= new Intent(this, Register2Activity.class);

        String email = edit1.getText().toString();
        String password = edit2.getText().toString();
        String confirm_password = edit3.getText().toString();
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radio1 = findViewById(selectedId);
        String role = radio1.getText().toString();

        if (email==null || password == null || confirm_password == null || selectedId ==-1)
            errorMsg.setText("All the fields must be filled");

        else if (!password.equals(confirm_password))
            errorMsg.setText("Passwords are not matching");

        else {
            intent.putExtra("email", email);
            intent.putExtra("password", password);
            intent.putExtra("role", role);
            startActivity(intent);
        }
    }
}
