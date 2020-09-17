package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CollectionsMen extends AppCompatActivity {

    private ImageView S1;
    private ImageView S2;
    private ImageView S3;
    private ImageView S4;
    private TextView p1;
    private TextView p2;
    private TextView p3;
    private TextView p4;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;

    DatabaseReference databaseReference;

    String cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections_men);

        b1 = findViewById(R.id.Shirt1);
        b2 = findViewById(R.id.Shirt2);
        b3 = findViewById(R.id.Shirt3);
        b4 = findViewById(R.id.Shirt4);
        p1 = findViewById(R.id.price1);
        p2 = findViewById(R.id.price2);
        p3 = findViewById(R.id.price3);
        p4 = findViewById(R.id.price4);

        databaseReference = FirebaseDatabase.getInstance().getReference();


       b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                cost=p1.getText().toString().trim();
                saveData(cost);
                Intent i=new Intent(CollectionsMen.this,PaymentMethod.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //store("b2Shirt");
                cost=p2.getText().toString().trim();
                saveData(cost);
                Intent i=new Intent(CollectionsMen.this,PaymentMethod.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cost=p3.getText().toString().trim();
               saveData(cost);
                Intent i=new Intent(CollectionsMen.this,PaymentMethod.class);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cost=p4.getText().toString().trim();
                saveData(cost);
                Intent i=new Intent(CollectionsMen.this,PaymentMethod.class);
                startActivity(i);
            }
        });
    }


    public void saveData(String cost)
    {
        //String cost = p1.getText().toString().trim();
        String key=databaseReference.push().getKey();
        dataHandler dataHandler=new dataHandler(cost);

        databaseReference.child(key).setValue(dataHandler);
    }
}
