package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lifecycleapp.broadcastReceiver.AirplaneModeChangeReceiver;
import com.example.lifecycleapp.broadcastReceiver.MyCustomBroadcastReceiver;
import com.example.lifecycleapp.broadcastReceiver.WifiReceiver;
import com.example.lifecycleapp.databinding.ActivityLaunchmodelistactivityBinding;
import com.example.lifecycleapp.globalDatas.PassDataTest;


public class LaunchModeListActivity extends AppCompatActivity {

    ActivityLaunchmodelistactivityBinding binding;

    public int id = 1;

    WifiReceiver wifiReceiver = new WifiReceiver();

    AirplaneModeChangeReceiver airplaneModeChangeReceiver =
            new AirplaneModeChangeReceiver();

    MyCustomBroadcastReceiver myCustomBroadcastReceiver =
            new MyCustomBroadcastReceiver();


    @Override
    protected void onStart(){
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeChangeReceiver, filter);
        IntentFilter wifiFilter = new IntentFilter();
        wifiFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
        registerReceiver(wifiReceiver, wifiFilter);
    }

    @Override
    protected void onStop(){
        super.onStop();
        unregisterReceiver(wifiReceiver);
        unregisterReceiver(airplaneModeChangeReceiver);
//        unregisterReceiver(myCustomBroadcastReceiver);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLaunchmodelistactivityBinding.inflate(getLayoutInflater());
        View bindingView = binding.getRoot();

        setContentView(bindingView);

        binding.linearLayoutBtn.setOnClickListener(view -> intentToAnotherActivity(
                "Linear Layout"
        ));
        binding.relativeLayoutBtn.setOnClickListener(view -> intentToAnotherActivity(
                "Relative Layout"
        ));

        binding.constraintLayoutBtn.setOnClickListener(view -> intentToAnotherActivity(
                  "Constraint Layout"
        ));

        binding.constraintLayoutDataBindBtn.setOnClickListener(view ->
        intentToAnotherActivity(
                 "Constraint Layout With Data Bind"
        ));

        binding.fragmentLifeCycleBtn.setOnClickListener(view -> {
            intentToAnotherActivity (
                    "Fragment Life Cycle" );
            PassDataTest.Message = "Raam Sedhu RR";
            PassDataTest.Id = 111;
            PassDataTest.Val = true;
        });

        binding.fragmentLayoutBtn.setOnClickListener(view ->
         intentToAnotherActivity("Fragment Layout Activity"));

        binding.progressBarBtn.setOnClickListener(view ->
         intentToAnotherActivity("Progress Bar Service Activity"));

        binding.btnSharedPreference.setOnClickListener(view ->
         intentToAnotherActivity("Shared Preferences Activity"));

        binding.btnSqlDB.setOnClickListener(view -> intentToAnotherActivity("SQL DB Activity"));

        binding.customBroadCast.setOnClickListener(view -> {
            Intent broadcastIntent = new Intent();
            registerReceiver(myCustomBroadcastReceiver, new
                    IntentFilter("android.example.lifecycleapp.CUSTOM_INTENT"));
            broadcastIntent.setAction("android.example.lifecycleapp.CUSTOM_INTENT");
            sendBroadcast(broadcastIntent);
        });

        binding.btnDagger2.setOnClickListener(view -> intentToAnotherActivity("Dagger 2 Activity"));
        binding.btnMVP.setOnClickListener(view -> intentToAnotherActivity("MVP Activity"));

    }

    private void intentToAnotherActivity(
             String activityFlag) {
        switch (activityFlag) {
            case "Linear Layout": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                                LinearLayoutWithRecyclerActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Linear Layout",
                               Toast.LENGTH_LONG).show();
                break;
            }
            case "Relative Layout": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                                           RelativeLayoutWithListActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Relative Layout",
                               Toast.LENGTH_LONG).show();
                break;
            }
            case "Constraint Layout": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                                           ConstraintLayoutWithGridActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Constraint Layout",
                               Toast.LENGTH_LONG).show();
                break;
            }
            case "Constraint Layout With Data Bind": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                ConstraintLayoutWithRecyclerViewDataBindingActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                               "Constraint Layout With Data Bind",
                               Toast.LENGTH_LONG).show();
                break;
            }
            case "Fragment Life Cycle": {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.codingmart.com"));
                startActivity(i);
                break;
            }
            case "Fragment Layout Activity": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                                           FragmentLayoutActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Fragment Layout Activity",
                               Toast.LENGTH_LONG).show();
                break;
            }
            case "Progress Bar Service Activity": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                                           ServiceProgressBarActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Progress Bar Service Activity",
                               Toast.LENGTH_LONG).show();
                break;
            }
            case "Shared Preferences Activity": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                                           SharedPreferencesActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Shared Preferences Activity",
                               Toast.LENGTH_LONG).show();
                break;
            }
            case "SQL DB Activity": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                                           SqliteDBActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "SQL DB Activity",
                               Toast.LENGTH_LONG).show();
                break;
            }
            case "Dagger 2 Activity": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                                           Dagger2Activity.class);
                startActivity(intent);
                break;
            }
            case "MVP Activity": {
                Intent intent = new Intent(LaunchModeListActivity.this,
                                           MVPActivity.class);
                startActivity(intent);
                break;
            }

            default: {
                break;
            }
        }

    }

}