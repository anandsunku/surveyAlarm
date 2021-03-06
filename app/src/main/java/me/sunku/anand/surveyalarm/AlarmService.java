package me.sunku.anand.surveyalarm;


import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by anand on 31/08/16.
 */

public class AlarmService extends IntentService {

    private NotificationManager alarmNotificationManager;

    public AlarmService(){
        super("AlarmService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        sendNotification("Wake up! wake up!");
    }

    private void sendNotification(String msg){
        Log.d("AlarmService", "Preparing to send notification..." +msg);
        alarmNotificationManager = (NotificationManager)this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this,0,
                new Intent(this,AlarmActivity.class),0);

        NotificationCompat.Builder alarmNotificationBuilder = new NotificationCompat.Builder(this).setContentTitle("Alarm").setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg);

        alarmNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1,alarmNotificationBuilder.build());
        Log.d("AlarmService","Notification sent.");
    }
}
