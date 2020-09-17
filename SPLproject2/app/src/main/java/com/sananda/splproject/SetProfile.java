package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetProfile extends AppCompatActivity {

    EditText name;
    EditText Address;
    EditText phone;
    EditText Length;
    EditText Body;
    Button saveProfile;
    Button gotoMenu;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_profile);

        databaseReference= FirebaseDatabase.getInstance().getReference();

         name = findViewById(R.id.name);
         Address = findViewById(R.id.Address);
         phone = findViewById(R.id.phone);
         Length = findViewById(R.id.length);
         Body = findViewById(R.id.body);

         saveProfile = findViewById(R.id.SaveProfile);
         gotoMenu=findViewById(R.id.ProfileToMenu);

        gotoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SetProfile.this,Menu.class);
                startActivity(intent);
            }
        });

        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveProfile();
            }
        });

    }


    public void saveProfile() {

        String Cust_name = name.getText().toString().trim();
        String address = Address.getText().toString().trim();
        String Phone= phone.getText().toString().trim();
        String length= Length.getText().toString().trim();
        String body=Body.getText().toString().trim();

        String key=databaseReference.push().getKey();
        ProfileData profileData=new ProfileData(Cust_name,address,Phone,length,body);

        databaseReference.child(key).setValue(profileData);

    }
}
