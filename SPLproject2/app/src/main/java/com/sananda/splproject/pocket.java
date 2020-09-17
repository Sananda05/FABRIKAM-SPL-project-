package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class pocket extends AppCompatActivity {

    String tag;

    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocket);

        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);

         Button b1 = findViewById(R.id.button1);
         Button b2 = findViewById(R.id.button2);
         Button b3 = findViewById(R.id.button3);
         Button b4 = findViewById(R.id.button4);
         Button next=findViewById(R.id.next);

         databaseReference= FirebaseDatabase.getInstance().getReference();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(pocket.this, measurement.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag=t1.getText().toString().trim();
                saveData(tag);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag=t2.getText().toString().trim();
                saveData(tag);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag=t3.getText().toString().trim();
                saveData(tag);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag=t4.getText().toString().trim();
                saveData(tag);
            }
        });
    }

    private void saveData(String tag) {

        String key=databaseReference.push().getKey();
        FabricDataHandler fabricDataHandler =new FabricDataHandler(tag);

        databaseReference.child(key).setValue(fabricDataHandler);
    }
}
