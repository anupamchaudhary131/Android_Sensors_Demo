package com.example.android_sensors_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAccelerometer, btnProximity, btnAmbient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAccelerometer = findViewById(R.id.btnAccelerometer);
        btnProximity = findViewById(R.id.btnProximity);
        btnAmbient = findViewById(R.id.btnAmbient);


        btnAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iAccelerometer = new Intent(MainActivity.this, Accelerometer_Sensor.class);
                startActivity(iAccelerometer);
            }
        });


        btnProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iProximity = new Intent(MainActivity.this, Proximity_Sensor.class);
                startActivity(iProximity);
            }
        });


        btnAmbient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent iAmbient = new Intent(MainActivity.this, Ambient_Light_Sensor.class);
                startActivity(iAmbient);
            }
        });
    }
}