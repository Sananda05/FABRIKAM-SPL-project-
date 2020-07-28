package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DesignType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_type);

        Button create = findViewById(R.id.Create);
        Button ReadyDesign=findViewById(R.id.Readydesign);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DesignType.this,CreateDesign.class);
                startActivity(i);
            }
        });

        ReadyDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DesignType.this,CollectionsMen.class);
                startActivity(i);
            }
        });

    }
}
