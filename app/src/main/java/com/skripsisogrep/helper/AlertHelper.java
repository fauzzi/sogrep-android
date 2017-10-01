package com.skripsisogrep.helper;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.skripsisogrep.activity.LoginActivity;
import com.skripsisogrep.sogrep.R;

/**
 * Created by Akhmad Fauzi Hasibuan on 8/14/2017.
 * akhmadfauzihasibuan@gmail.com
 * https://github.com/fauzzi
 */

public class AlertHelper {

    public static void LogoutDialog(final Context context) {
        final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context, R.style.AlertDialog);
        builder.setMessage("Apakah anda yakin ingin keluar?");
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(context, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intent);


            }
        });
        builder.show();
    }

}