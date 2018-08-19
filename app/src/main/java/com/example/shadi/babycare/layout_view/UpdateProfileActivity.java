package com.example.shadi.babycare.layout_view;

import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.shadi.babycare.R;

public class UpdateProfileActivity extends BaseActivity {

    private ImageView pic;
    private EditText city, description;
    private Spinner district, neighbourhood;
    private CharSequence spinner1, spinner2;
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_update_profile, fl);

        city = findViewById(R.id.upd_city);
        description = findViewById(R.id.update_descr);
        district = findViewById(R.id.upd_district);
        neighbourhood = findViewById(R.id.upd_neighbourhood);
        update = findViewById(R.id.update);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array,
                R.layout.spinner_item);
        ArrayAdapter<CharSequence> districta = ArrayAdapter.createFromResource(this, R.array.planets_array1,
                R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        district.setAdapter(districta);
        neighbourhood.setAdapter(adapter);

        //listener for district
        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner1 = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner1 = null;
            }
        });

        //listener for district
        neighbourhood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner2 = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner2 = null;
            }
        });

        super.setTitle("Update profile");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO backend call, manda le modifiche del profilo fatte
            }
        });

    }
}
