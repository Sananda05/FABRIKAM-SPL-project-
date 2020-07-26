package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KidsItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_item);

       Button boy=findViewById(R.id.Boy);
        Button girl=findViewById(R.id.Girl);


        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(KidsItem.this, CollectionKidsBoy.class);
                startActivity(intent);
            }
        });

        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(KidsItem.this, CollectionKidsGirl.class);
                startActivity(intent);
            }
        });
    }
}
