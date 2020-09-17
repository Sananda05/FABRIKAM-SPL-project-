package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CreateDesign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_design);

        Button fabric=findViewById(R.id.fabric);
        Button pocket=findViewById(R.id.pocket);
        Button sleeve =findViewById(R.id.sleeve);

        fabric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(CreateDesign.this, Fabrics.class);
                startActivity(intent);

            }
        });
        pocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(CreateDesign.this, pocket.class);
                startActivity(intent);

            }
        });
        sleeve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(CreateDesign.this, sleeve.class);
                startActivity(intent);

            }
        });


    }
}
