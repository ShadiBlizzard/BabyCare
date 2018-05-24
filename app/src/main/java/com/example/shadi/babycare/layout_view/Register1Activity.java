package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shadi.babycare.R;

public class Register1Activity extends AppCompatActivity {

    private EditText edit1, edit2, edit3;
    private RadioGroup radioGroup;
    private RadioButton radio1;
    private TextView errorMsg;
    private String role;
    private Button goOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit1 = findViewById(R.id.emailreg);
        edit2 = findViewById(R.id.passwordreg);
        edit3 = findViewById(R.id.password2reg);
        radioGroup = findViewById(R.id.radioGroup);
        errorMsg = findViewById(R.id.errorregister);
        goOn = findViewById(R.id.goon1);

        goOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radio1 = findViewById(selectedId);
                role = radio1.getText().toString();
                int result = checkParametersValidity();
                if(result == 0)
                    goOn();
            }
        });

    }

    private void goOn () {
        Intent intent = new Intent(this, Register2Activity.class);
        intent.putExtra("email", edit1.getText().toString());
        intent.putExtra("password", edit2.getText().toString());
        intent.putExtra("role", role);
        startActivity(intent);
    }

    /**
     * It checks the validity of the input data
     */
    private int checkParametersValidity() {
        int ok = 0;
        if (isEmpty(edit2)) {
            edit2.setError("Password required!");
            ok++;
        }

        if (isEmpty(edit3)) {
            edit3.setError("Confirm password required!");
            ok++;
        }
        if (!isEmail(edit1)) {
            Toast t = Toast.makeText(this, "You must enter a valid e-mail address!", Toast.LENGTH_SHORT);
            t.show();
            ok++;
        }
        if(!matchingPassword(edit2, edit3)) {
            Toast t = Toast.makeText(this, "Password not matching", Toast.LENGTH_SHORT);
            t.show();
            ok++;
        }

        return ok;

    }

    /**
     * Method used to verify the correctness of the input
     * @param email
     * @return TRUE if email
     */
    private boolean isEmail (EditText email) {
        CharSequence input = email.getText().toString();
        return (!TextUtils.isEmpty(input) && Patterns.EMAIL_ADDRESS.matcher(input).matches());
    }

    /**
     * Method used to verify if the content of one field is empty or not
     * @param text
     * @return TRUE if empty
     */
    private boolean isEmpty (EditText text) {
        CharSequence input = text.getText().toString();
        return TextUtils.isEmpty(input);
    }

    /**
     * Method used to verify if the password are matching
     * @param pass
     * @param conf
     * @return TRUE if equals
     */
    private boolean matchingPassword (EditText pass, EditText conf) {
        CharSequence input1 = pass.getText().toString();
        CharSequence input2 = conf.getText().toString();
        return TextUtils.equals(input1, input2);
    }
}
