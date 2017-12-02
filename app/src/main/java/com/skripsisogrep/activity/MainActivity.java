package com.skripsisogrep.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.pushbots.push.Pushbots;
import com.skripsisogrep.adapters.MainAdapter;
import com.skripsisogrep.base.DrawerLayoutActivity;
import com.skripsisogrep.customHandler;
import com.skripsisogrep.models.Optik;
import com.skripsisogrep.sogrep.R;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends DrawerLayoutActivity {

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private View view;

    @Override
    protected void onViewCreated() {

        Pushbots.sharedInstance().registerForRemoteNotifications();
        Pushbots.sharedInstance().setCustomHandler(customHandler.class);


        mTitle.setText("Pemetaan Optik Di Medan");

        view = LayoutInflater.from(getBaseContext()).inflate(R.layout.activity_main, frameLayout);

        recyclerView = ButterKnife.findById(view, R.id.recycleView);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainAdapter(new MainAdapter.onItemClickListener() {
            @Override
            public void onSeeMoreClick(View view, Optik data) {

                Intent intent = new Intent(MainActivity.this, MainDetailActivity.class);
                startActivity(intent);
            }
        });
        adapter.setItems(getData());
        recyclerView.setAdapter(adapter);

    }

    private ArrayList getData() {
        ArrayList data = new ArrayList();
        data.add(new Optik("Trend Optik", "Medan Mall Lt. 1 No. 2 & 47, Jalan Jend. Gatot Subroto, Sekip, Medan Petisah, Kota Medan, Sumatera Utara 20113", "09:00AM", "09:00PM", "(061) 4523148", "4", R.drawable.optik_one));
        data.add(new Optik("BPJS Kesehatan", " Jl. K. L. Yos Sudarso, Tj. Mulia, Medan Deli, Kota Medan, Sumatera Utara 20241", "09:00AM", "09:00PM", "(061) 4523148", "4", R.drawable.optik_two));
        data.add(new Optik("Optik Kalimantan", "Jl.HM.THAMRIN no.3A./simpang jl.bandar baru, lewat sedikit lampu merah RS.PIRNGADI, Sidodadi, Medan Tim., Kota Medan, Sumatera Utara 20232", "08:30AM", "06:00PM", "(061) 4143288", "4", R.drawable.optik_thee));
        data.add(new Optik("Optik Indonusa", "Jalan Jendral Gatot Subroto No.50/94, Petisah Tengah, Medan Petisah, Silalas, Medan Bar., Kota Medan, Sumatera Utara 20236", "08:00AM", "06:00PM", " (061) 4513897", "4", R.drawable.optik_four));
        data.add(new Optik("BPJS", "Gg. Gelatik Jl. Pasar III No.4 D, Tegal Rejo, Medan Perjuangan, Kota Medan, Sumatera Utara 20237", "08:00AM", "06:00PM", "0823-6282-2747", "4", R.drawable.optik_five));
        return data;
    }
}