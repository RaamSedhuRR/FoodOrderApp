package com.example.lifecycleapp.broadcastReceiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class WifiReceiver extends BroadcastReceiver{



    @SuppressLint("SetTextI18n")
    @Override
    public void onReceive(Context context, Intent intent){
        final String action = intent.getAction();
        if (action.equals(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION)) {
            if (intent.getBooleanExtra(WifiManager.EXTRA_SUPPLICANT_CONNECTED, false)) {

                Toast.makeText(context,"Wifi On ",Toast.LENGTH_LONG).show();

            } else {

                Toast.makeText(context,"Wifi Off ",Toast.LENGTH_LONG).show();

            }
        }

    }
}
