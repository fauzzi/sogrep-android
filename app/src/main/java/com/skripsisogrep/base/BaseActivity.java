package com.skripsisogrep.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Akhmad Fauzi Hasibuan on 8/13/2017.
 * akhmadfauzihasibuan@gmail.com
 * https://github.com/fauzzi
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    @Deprecated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResource());
        onBindView();
        onViewCreated();
    }

    protected void onBindView() {
        ButterKnife.bind(this);
    }

    @LayoutRes
    protected abstract int getContentViewResource();

    protected abstract void onViewCreated();

}