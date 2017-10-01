package com.skripsisogrep.activity;

import android.content.Intent;

import com.skripsisogrep.base.ToolbarActivity;
import com.skripsisogrep.sogrep.R;

public class MainDetailActivity extends ToolbarActivity {

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_main_detail;
    }

    @Override
    protected void onViewCreated() {

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainDetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}