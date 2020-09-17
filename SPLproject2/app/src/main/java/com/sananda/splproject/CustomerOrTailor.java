package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerOrTailor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_or_tailor);

        Button customer = findViewById(R.id.Customer);
        Button tailor= findViewById(R.id.tailor);

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomerOrTailor.this,SetProfile.class);
                startActivity(intent);
                finish();
            }
        });

        tailor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(CustomerOrTailor.this, TailorView.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
