package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sleeve extends AppCompatActivity {

    String sleeveType;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleeve);

        databaseReference= FirebaseDatabase.getInstance().getReference();

        Button Full = findViewById(R.id.Full);
        Button Half = findViewById(R.id.Half);
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(sleeve.this, pocket.class);
                startActivity(intent);
            }
        });

        Full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleeveType="Full Sleeve";
                saveData(sleeveType);
            }
        });
        Half.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleeveType="Half Sleeve";
                saveData(sleeveType);
            }
        });
    }

    private void saveData(String sleeveType) {

        String key=databaseReference.push().getKey();
        FabricDataHandler fabricDataHandler =new FabricDataHandler(sleeveType);

           databaseReference.child(key).setValue(fabricDataHandler);
    }
}
