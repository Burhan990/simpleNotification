package com.example.simplenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.simplenotification.app.Channel_ID1;
import static com.example.simplenotification.app.Channel_ID2;

public class MainActivity extends AppCompatActivity{

    private final String Channel_ID="personal notification";
    private final int notification_ID=001;
    Button notification;

    NotificationManagerCompat notificationmanager;
    private EditText edtTitle,edtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationmanager=NotificationManagerCompat.from(this);

        edtTitle=(EditText)findViewById(R.id.Title);
        edtDescription=(EditText)findViewById(R.id.description);




      //  notification=(Button)findViewById(R.id.btnNotification);
       // notification.setOnClickListener(this);

    }



    public void sendOnChannel1(View view) {

        String Title=edtTitle.getText().toString();
        String Description=edtDescription.getText().toString();

        Notification notification=new NotificationCompat.Builder(this,Channel_ID1)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle(Title)
                .setContentText(Description)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_CALL)
                .build();

        notificationmanager.notify(1,notification);
    }

    public void sendOnChannel2(View view) {

        String Title=edtTitle.getText().toString();
        String Description=edtDescription.getText().toString();

        Notification notification=new NotificationCompat.Builder(this,Channel_ID2)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle(Title)
                .setContentText(Description)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationmanager.notify(2,notification);
    }
}
