package com.example.lifecycleapp.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.lifecycleapp.R;
import com.example.lifecycleapp.fragments.ForegroundServicesFragment;

import java.util.Timer;
import java.util.TimerTask;


public class MediaPlayerService extends Service{

    private MediaPlayer mediaPlayer;

    int progressCounter = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        if(intent != null){

            mediaPlayer =  MediaPlayer.create(this, R.raw.music);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
            progressBar();
            return START_STICKY;

        }else{
            return START_NOT_STICKY;
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    public void progressBar(){

        final Timer progressTimer = new Timer();
        TimerTask progressTimerTask = new TimerTask(){
            @Override
            public void run(){
                progressCounter = progressCounter + 5;
                Log.d("ProgressCounter :", String.valueOf(progressCounter));
                Intent intent = new Intent("custom-action-local-broadcast");
                intent.putExtra("progressCounter", progressCounter);
                LocalBroadcastManager.getInstance(ForegroundServicesFragment.progressBarId.getContext()).sendBroadcast(intent);
                if(progressCounter == 100){
                    Intent finalIntent = new Intent("custom-action-local-broadcast");
                    finalIntent.putExtra("progressCounter", progressCounter);
                    LocalBroadcastManager.getInstance(ForegroundServicesFragment.progressBarId.getContext()).sendBroadcast(finalIntent);
                    progressTimer.cancel();
                }
            }
        };
        progressTimer.schedule(progressTimerTask,0,500);

    }



}
