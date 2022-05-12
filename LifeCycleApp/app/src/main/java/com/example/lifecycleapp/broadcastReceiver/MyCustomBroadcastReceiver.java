package com.example.lifecycleapp.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyCustomBroadcastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context,"Custom Broadcast",Toast.LENGTH_LONG).show();
    }
}
