package com.sananda.splproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cust_profile extends AppCompatActivity {

    private ListView listView;

    DatabaseReference databaseReference;
    private List<ProfileData> profileList;
    private ProfileAdapter profileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_profile);

        databaseReference= FirebaseDatabase.getInstance().getReference();
        profileList=new ArrayList<>();
        profileAdapter=new ProfileAdapter(Cust_profile.this,profileList);

        listView=findViewById(R.id.profileList);
    }

    public void onStart(){

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profileList.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    ProfileData profileData =dataSnapshot.getValue(ProfileData.class);
                    profileList.add(profileData);
                }
                listView.setAdapter(profileAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}
