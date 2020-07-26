package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CollectionKidsBoy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_kids_boy);

        Button Shirt = findViewById(R.id.Shirt);

        Shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(CollectionKidsBoy.this, DisplayBoyKids.class);
                startActivity(intent);
            }
        });

    }
}
