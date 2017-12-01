package com.example.android.basicblocks;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by pc on 11/29/2017.
 */

public class NetworkRe extends BroadcastReceiver {

    private static final String LOG_TAG = "NetworkReceiver";
    private boolean isConnected = false;
    AlertDialog.Builder builder;
    public boolean isConnected1;




    @Override
    public void onReceive(Context context, Intent intent) {
        builder = new AlertDialog.Builder(context);

        builder.setTitle("ARE YOU CONNECTED ?");
        builder.setMessage(isNetworkAvailable(context));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    private String isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivity!=null)) {
            NetworkInfo activeNetwork = connectivity.getActiveNetworkInfo();
            if (activeNetwork != null) {
                if (activeNetwork.getState() == NetworkInfo.State.CONNECTED) {
                    if (!isConnected) {
                        isConnected = true;
                    }
                    return "Now you are connected to the Internet";
                }
            }
        }
        isConnected=false;
        return "You are not connected to the Internet";
    }
    public boolean isConnected() {
        return isConnected;
    }

}