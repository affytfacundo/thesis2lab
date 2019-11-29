package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Views extends AppCompatActivity {

    Button driver, pedestrian, signout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        driver = findViewById(R.id.buttonDriver);
        pedestrian = findViewById(R.id.buttonPed);
        signout = findViewById(R.id.signOutBtn);

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goDrive();
            }
        });

        pedestrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goPedestrian();
            }
        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });



    }

    private void goDrive(){
        Intent intent = new Intent(Views.this, DriverDetails.class);
        startActivity(intent);
    }

    private void goPedestrian(){
        Intent intent2 = new Intent(Views.this, PedestrianDetails.class);
        startActivity(intent2);
    }

    private void signOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent3 = new Intent(Views.this, MainActivity.class);
        intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent3);
        //try
    }
}
