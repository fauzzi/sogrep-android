package com.skripsisogrep;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.pushbots.push.Pushbots;
import com.pushbots.push.utils.PBConstants;
import com.skripsisogrep.activity.MainActivity;
import com.skripsisogrep.sogrep.R;

/**
 * Created by Akhmad Fauzi Hasibuan on 12/2/2017
 * akhmadfauzihasibuan@gmail.com
 * https://github.com/fauzzi
 */
public class customHandler extends BroadcastReceiver {

    private String TAG = "PB3";

    private void showNotification(Context context) {
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
        mBuilder.setContentIntent(contentIntent);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e(TAG, "action=" + action);

        // Handle Push Message when opened
        if (action.equals(PBConstants.EVENT_MSG_OPEN)) {

            //Bundle containing all fields of the opened notification
            Bundle bundle = intent.getExtras().getBundle(PBConstants.EVENT_MSG_OPEN);


            //Record opened notification
            Pushbots.PushNotificationOpened(context, bundle);

            Log.e(TAG, "User clicked notification with Message: " + bundle.get("message"));

            Log.e(TAG, "message" + bundle.get("message"));
            Log.e(TAG, "title" + bundle.get("nTitle"));
            Log.e(TAG, "article_id" + bundle.get("article_id"));
            Log.e(TAG, "icon" + bundle.get("sIco"));

            //Get Custom field key e.g. article_id
            if (bundle.get("article_id") != null)
                Log.e(TAG, "Article Id: " + bundle.get("article_id"));

            //Start Launch Activity
            String packageName = context.getPackageName();
            Intent resultIntent = new Intent(context.getPackageManager().getLaunchIntentForPackage(packageName));
            resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            // Check for next activity
            String next_activity = bundle.getString("nextActivity");
            if (null != next_activity) {
                try {
                    Log.e(TAG, "Opening Custom Activity " + next_activity);
                    resultIntent = new Intent(context, Class.forName(next_activity));
                    resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                } catch (ClassNotFoundException e) {
                    //ClassNotFound
                    e.printStackTrace();
                }
            }

            // Check for open URL
            String open_url = bundle.getString("openURL");
            if (null != open_url && (open_url.startsWith("http://") || open_url.startsWith("https://"))) {
                resultIntent = new Intent("android.intent.action.VIEW", Uri.parse(open_url));
                resultIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Log.e(TAG, "Opening url: " + open_url);
            }

            resultIntent.putExtras(intent.getBundleExtra("pushData"));

            //Open activity or URL with pushData.
            if (null != resultIntent) {
                context.startActivity(resultIntent);
            }

        } else if (action.equals(PBConstants.EVENT_MSG_RECEIVE)) {


//            showNotification(context);
            //Bundle containing all fields of the notification
            Bundle bundle = intent.getExtras().getBundle(PBConstants.EVENT_MSG_RECEIVE);
            Log.e(TAG, "User received notification with Message: " + bundle.get("message"));
        }

    }
}
