package com.example.ex3_quotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.quotes_start).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();

                Intent intent = new Intent(getApplicationContext(), Notification_Receiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT); // In order to be able to update in the future

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_FIFTEEN_MINUTES / 15 , pendingIntent); // Every minute pop notification
            }
        });
    }
}