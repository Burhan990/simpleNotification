package com.example.simplenotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Build;

public class app extends Application {

    public static final String Channel_ID1="channel1";
    public static final String Channel_ID2="channel2";

    @Override
    public void onCreate() {
        super.onCreate();

        CreateNotificationChannel();


    }

    private void CreateNotificationChannel() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            NotificationChannel channel1=new NotificationChannel(
                Channel_ID1,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("this is channel 1");

            NotificationChannel channel2=new NotificationChannel(
                    Channel_ID2,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("This is Channel 2");

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

        }
    }
}
