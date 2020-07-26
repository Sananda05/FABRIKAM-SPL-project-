package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category extends AppCompatActivity {

    private Button Men;
    private Button women;
    private Button kids;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Men=findViewById(R.id.men);
        women=findViewById(R.id.women);
        kids=findViewById(R.id.kids);
        back=findViewById(R.id.back);

        Men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(Category.this,Item.class);
                startActivity(intent);
            }
        });

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(Category.this,WomenIten.class);
                startActivity(intent);
            }
        });

        kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent;
                intent = new Intent(Category.this,KidsItem.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(Category.this,Menu.class);
                startActivity(intent);
            }
        });



    }
}
