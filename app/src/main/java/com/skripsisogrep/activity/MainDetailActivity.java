package com.skripsisogrep.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.skripsisogrep.base.ToolbarActivity;
import com.skripsisogrep.models.Optik;
import com.skripsisogrep.sogrep.R;

import org.parceler.Parcels;

import butterknife.BindView;

public class MainDetailActivity extends ToolbarActivity {

    public static final String EXTRA_DETAIL = "detail";
    private Optik mData;

    @BindView(R.id.address)
    TextView mAddress;
    @BindView(R.id.open_time)
    TextView mOpenTime;
    @BindView(R.id.close_time)
    TextView mCloseTime;
    @BindView(R.id.phone)
    TextView mPhone;
    @BindView(R.id.picture)
    ImageView mPicture;


    @Override
    protected int getContentViewResource() {
        return R.layout.activity_main_detail;
    }

    @Override
    protected void onViewCreated() {

        Bundle extras = getIntent().getExtras();
        mData = Parcels.unwrap(extras.getParcelable(EXTRA_DETAIL));
        if (mData != null) {
            mTitle.setText(mData.getName());
            mAddress.setText(mData.getAddress());
            mOpenTime.setText(mData.getOpen_time());
            mCloseTime.setText(mData.getClose_time());
            mPhone.setText(mData.getPhone());
            mPicture.setImageResource(mData.getPicture());
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainDetailActivity.this, MainActivity.class);
        startActivity(intent);
    }
}