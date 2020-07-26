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

    int kount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections_men);

        b1 = findViewById(R.id.Shirt1);
        b2 = findViewById(R.id.Shirt2);
        b3 = findViewById(R.id.Shirt3);
        b4 = findViewById(R.id.Shirt4);


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //  store("b1Shirt");
                 kount++;
                Intent intent;
                intent = new Intent(CollectionsMen.this, Cust_profile.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //store("b2Shirt");

                Intent intent;
                intent = new Intent(CollectionsMen.this, Cust_profile.class);
                startActivity(intent);
            }
        });
    }

    private void store(String shirtName)
    {
        File f = new File("user.txt");
        try
        {
            if(!f.exists())
                f.createNewFile();
            BufferedWriter bf = new BufferedWriter(new FileWriter("user.txt"));
            bf.append(shirtName);
            Log.d("Activity_display", "In store");
            Toast.makeText(CollectionsMen.this,"Stored:" + shirtName,Toast.LENGTH_SHORT).show();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
