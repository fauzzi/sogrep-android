package com.skripsisogrep.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.skripsisogrep.activity.MainActivity;
import com.skripsisogrep.helper.AlertHelper;
import com.skripsisogrep.sogrep.R;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Akhmad Fauzi Hasibuan on 8/13/2017.
 * akhmadfauzihasibuan@gmail.com
 * https://github.com/fauzzi
 */

public abstract class DrawerLayoutActivity extends BaseDrawerActivity {

    @BindView(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    @BindView(R.id.title)
    protected TextView mTitle;

    @BindView(R.id.home)
    LinearLayout mBerandaView;

    @BindView(R.id.logout)
    LinearLayout mLogoutView;

    @BindView(R.id.profileView)
    LinearLayout mProfileView;

    @BindView(R.id.profileName)
    TextView mProfileName;

    @BindView(R.id.profileEmail)
    TextView mProfileEmail;

    @BindView(R.id.profilePicture)
    CircleImageView mProfilePicture;

    @BindView(R.id.contact_us)
    LinearLayout mContactUs;

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

        // navdrawer setup
        mDrawerToggle = setupDrawerToggle();
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        try {
            // set drawer profile
//            final String profileName = API.getUser().getData().getFullName();
//            final String profileEmail = API.getUser().getData().getEmail();
//            mProfileName.setText(profileName);
//            mProfileEmail.setText(profileEmail);
//            FunctionHelper.setProfilePicture(this, mProfilePicture);

        } catch (Exception e) {
            e.printStackTrace();
        }


//        mProfileView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(DrawerLayoutActivity.this, ProfileActivity.class));
//                closeDrawer(view);
//            }
//        });

        mBerandaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DrawerLayoutActivity.this, MainActivity.class));
                closeDrawer(view);
            }
        });

        mLogoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertHelper.LogoutDialog(DrawerLayoutActivity.this);
                closeDrawer(view);
            }
        });


        mContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                closeDrawer(view);
            }
        });
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

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, this.toolbar, R.string.open, R.string.close);
        return mDrawerToggle;
    }

    public void closeDrawer(View view) {
        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }

}