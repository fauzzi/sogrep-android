package com.skripsisogrep.activity;

import android.widget.CheckBox;
import android.widget.EditText;

import com.skripsisogrep.base.ToolbarActivity;
import com.skripsisogrep.sogrep.R;

import java.io.File;

import butterknife.BindView;

public class RegisterActivity extends ToolbarActivity {

    private static final String TAG = "RegisterActivity";
    @BindView(R.id.email)
    EditText mEmail;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.name)
    EditText mName;
    @BindView(R.id.address)
    EditText mAddress;
    @BindView(R.id.phone)
    EditText mPhone;
    @BindView(R.id.employment)
    EditText mEmployment;
    @BindView(R.id.checkboxTerm)
    CheckBox mCheckTerm;

    @Override
    protected int getContentViewResource() {
        return R.layout.activity_register;
    }

    @Override
    protected void onViewCreated() {
        mTitle.setText("DAFTAR");
    }

}