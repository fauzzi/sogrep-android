package com.skripsisogrep.activity;


import android.content.Intent;

import com.skripsisogrep.base.BaseActivity;
import com.skripsisogrep.sogrep.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onViewCreated() {

        Thread welcomeThread = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    sleep(3000);
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
            }
        };
        welcomeThread.start();
    }
}
