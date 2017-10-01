package com.skripsisogrep.activity;

import android.content.Intent;

import com.skripsisogrep.base.BaseActivity;
import com.skripsisogrep.sogrep.R;

import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @Override
    protected int getContentViewResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onViewCreated() {

    }

    @OnClick(R.id.sign_in_button)
    void onLoginPress() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @OnClick(R.id.textRegister)
    void onRegisterPress() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}
