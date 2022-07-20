package com.example.android_sensors_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Proximity_Sensor extends AppCompatActivity implements SensorEventListener {

    TextView txtValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);

        txtValues =  findViewById(R.id.txtValues);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager != null){
            
            Sensor proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            
            if(proximitySensor != null){
                sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType() == Sensor.TYPE_PROXIMITY){
            txtValues.setText("Values: " +event.values[0]);

            if(event.values[0] > 0){
                Toast.makeText(this, "Object is far", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this, "Object is near", Toast.LENGTH_SHORT).show();
            }
        }
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}