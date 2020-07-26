package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Item extends AppCompatActivity {

    private Button shirt;
    private Button tshirt;
    private Button panjabi;
    private Button jeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        shirt=findViewById(R.id.Shirt);
        tshirt=findViewById(R.id.Tshirt);
        jeans=findViewById(R.id.Jeans);
        panjabi=findViewById(R.id.Punjabi);

        shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(Item.this, CollectionsMen.class);
                startActivity(intent);
            }
        });
    }
}
