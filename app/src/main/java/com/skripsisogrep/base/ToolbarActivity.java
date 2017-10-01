package com.skripsisogrep.base;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.skripsisogrep.sogrep.R;

import butterknife.BindView;

/**
 * Created by Akhmad Fauzi Hasibuan on 8/13/2017.
 * akhmadfauzihasibuan@gmail.com
 * https://github.com/fauzzi
 */

public abstract class ToolbarActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.title)
    protected TextView mTitle;

    @Override
    protected void onBindView() {
        super.onBindView();
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            toolbar.setTitle(null);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}