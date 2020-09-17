package com.sananda.splproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CustomOrderList extends AppCompatActivity {

    private ListView listView;

    DatabaseReference databaseReference;
    private List<FabricDataHandler> dataList;
    private FabricDataAdapter fabricDataAdapter;
    private Button backMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order_list);

        databaseReference= FirebaseDatabase.getInstance().getReference();
        dataList=new ArrayList<>();
        fabricDataAdapter= new FabricDataAdapter(CustomOrderList.this,dataList);

        listView=findViewById(R.id.ListViewId);

        backMenu=findViewById(R.id.backMenu);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomOrderList.this,Menu.class);
                startActivity(intent);
            }
        });
    }

    public void onStart(){

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    FabricDataHandler fabricDataHandler =dataSnapshot.getValue(FabricDataHandler.class);
                    dataList.add(fabricDataHandler);
                }
                listView.setAdapter(fabricDataAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}
