package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button shop;
    private Button measurement;
    private Button about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        shop=(Button)findViewById(R.id.shop);
        measurement=(Button)findViewById(R.id.measurement);
        about=(Button)findViewById(R.id.info) ;

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(Menu.this, Category.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(Menu.this, Info.class);
                startActivity(intent);
            }
        });

    }
}
