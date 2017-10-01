package com.skripsisogrep.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.skripsisogrep.sogrep.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Akhmad Fauzi Hasibuan on 8/13/2017.
 * akhmadfauzihasibuan@gmail.com
 * https://github.com/fauzzi
 */

public abstract class BaseDrawerActivity extends AppCompatActivity {

    @BindView(R.id.content_frame)
    protected FrameLayout frameLayout;

    @Override
    @Deprecated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.drawerlayout);
        onBindView();
        onViewCreated();
    }


    protected void onBindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        getLayoutInflater().inflate(layoutResID, frameLayout, true);
    }

    protected abstract void onViewCreated();

}
