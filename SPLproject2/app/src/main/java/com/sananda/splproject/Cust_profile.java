package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cust_profile extends AppCompatActivity {

    private TextView cartItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_profile);
    }

    public String read()
    {
        String s = "";
        File f = new File("user.txt");
        try {
            FileInputStream fIn = new FileInputStream(f);
            BufferedReader bf = new BufferedReader(new InputStreamReader(fIn));
            String line = bf.readLine();
            while(line != null)
                s += line;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(Cust_profile.this,"here:"+s,Toast.LENGTH_SHORT).show();
        return s;
    }
}
