package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WomenIten extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_iten);

        Button gown=findViewById(R.id.Gown);
        Button kamiz=findViewById(R.id.Kamiz);


        gown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(WomenIten.this, CollectionWomen.class);
                startActivity(intent);
            }
        });
    }
}
