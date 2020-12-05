package com.example.ex3_quotesapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import java.util.Random;


public class Notification_Receiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        
        // Intent
        Intent repeatingIntent = new Intent(context, Repeating_Activity.class);
        repeatingIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Replace old activity if still open.

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repeatingIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Generate random quotes from quotes_arr
        String[] quotesArray =  context.getResources().getStringArray(R.array.quotes_arr);
        String randomQuote = quotesArray[new Random().nextInt(quotesArray.length)];

        // Notification channel + manager
        NotificationChannel notificationChannel = new NotificationChannel("ID", "my_channel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);

        // Build notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, notificationChannel.getId())
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Ofir's Notification Quotes")
                .setContentText(randomQuote)
                .setAutoCancel(true);
        notificationManager.notify(100, builder.build());

    }
}
