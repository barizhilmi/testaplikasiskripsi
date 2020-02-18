package com.example.aplikasiskripsitest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWelcome = findViewById(R.id.btnWelcome);
        btnWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cekOnline()){
                    checkGpsEnabled(getApplicationContext());
                }
            }
        });
    }

    public boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public boolean cekOnline(){
        if(isOnline()){
            return true;
        }
        else {
            try {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Tidak Ada Koneksi Internet");
                alertDialog.setMessage("Hubungkan dengan jaringan data atau wifi untuk memulai");

                alertDialog.show();
        }catch (Exception ignored){

            }
            return false;
        }

    }

    private void checkGpsEnabled(Context context){
        LocationManager lm = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try{
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        }catch (Exception ignored){

        }

        try{
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }catch (Exception ignored){

        }

        if (!gps_enabled || !network_enabled){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("GPS Tidak Aktif");
            dialog.setPositiveButton(("open setting"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }
            });
            dialog.setNegativeButton(("Cancel"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
        }else{
            launchHalamanList();
        }
    }

    public void launchHalamanList(){
            Intent intent = new Intent(this, HalamanListActivity.class);
            startActivity(intent);
    }


}
