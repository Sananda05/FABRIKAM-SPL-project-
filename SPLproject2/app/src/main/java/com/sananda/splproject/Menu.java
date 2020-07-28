package com.sananda.splproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class Menu extends AppCompatActivity {

    private Button shop;
    private Button fabrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final DrawerLayout drawerLayout=findViewById(R.id.drawerlayout);
        findViewById(R.id.menuIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView=findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NotNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.profile) {
                    Intent intent;
                    intent = new Intent(Menu.this, Cust_profile.class);
                    startActivity(intent);
                } else if(id == R.id.aboutUS) {

                    Intent intent;
                    intent = new Intent(Menu.this, Info.class);
                    startActivity(intent);

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        shop=(Button)findViewById(R.id.shop);
        fabrics=(Button)findViewById(R.id.fabrics);

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(Menu.this, Category.class);
                startActivity(intent);
            }
        });

        fabrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(Menu.this, Fabrics.class);
                startActivity(intent);

            }
        });

         }
}
