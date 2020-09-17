package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class measurement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement);

        Button custom=findViewById(R.id.Customize);
        RadioGroup size = findViewById(R.id.size);
        RadioButton small= findViewById(R.id.small);
        RadioButton medium=findViewById(R.id.Medium);
        RadioButton large=findViewById(R.id.Large);
        RadioButton xLarge= findViewById(R.id.XLarge);

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(measurement.this,CustomOrderList.class);
                startActivity(intent);
            }
        });


    }

    public void OnRadioButton(View view) {
        boolean checked= ((RadioButton)view).isChecked();

        switch (view.getId())
        {
            case R.id.small:
                if(checked);
                break;
            case R.id.Medium:
                break;
            case R.id.Large:
                break;
            case R.id.XLarge:
                break;
        }
    }
}
