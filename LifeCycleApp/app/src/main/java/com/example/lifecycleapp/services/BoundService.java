package com.example.lifecycleapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BoundService extends Service{
    public BoundServiceBinder boundServiceBinder = new BoundServiceBinder();

    public BoundService(){
    }

    @Override
    public IBinder onBind(Intent intent){

        return boundServiceBinder;
    }

    public String getSystemTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss  -  dd/MM/yyy", Locale.ENGLISH);
        return simpleDateFormat.format(new Date());
    }

    public class BoundServiceBinder extends Binder{
        public BoundService getBoundService(){
            return BoundService.this;
        }
    }
}