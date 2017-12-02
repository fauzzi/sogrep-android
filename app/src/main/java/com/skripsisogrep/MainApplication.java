package com.skripsisogrep;

import android.app.Application;
<<<<<<< HEAD
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.pushbots.push.Pushbots;
import com.skripsisogrep.activity.MainActivity;
import com.skripsisogrep.sogrep.R;
=======
>>>>>>> 145538146323b1263bfe98bb1829263ed6a24cfc

/**
 * Created by Akhmad Fauzi Hasibuan on 8/13/2017.
 * akhmadfauzihasibuan@gmail.com
 * https://github.com/fauzzi
 */

public class MainApplication extends Application {
    private static final String TAG = "MainApplication";


    @Override
    public void onCreate() {
        super.onCreate();
<<<<<<< HEAD
        // Initialize Pushbots Library
        Pushbots.sharedInstance().init(this);
=======

>>>>>>> 145538146323b1263bfe98bb1829263ed6a24cfc
    }
}