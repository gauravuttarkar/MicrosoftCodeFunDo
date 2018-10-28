package com.example.anu.coddefuundo;

import android.Manifest;
import android.location.Location;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLoc;
    public static TextView textView1;
    public static TextView textView02;
    public static TextView textView002,txts;
    public static TextView full;
    double lat,lon,z,y;
    String urlll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoc = (Button)findViewById(R.id.button);
        textView1 = (TextView)findViewById(R.id.textView);
        textView02 = (TextView)findViewById(R.id.textView3);
        textView002 = (TextView)findViewById(R.id.textView2);
        txts = (TextView)findViewById(R.id.textView4);
        full = (TextView)findViewById(R.id.textView5);
        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        btnLoc.setClickable(false);
        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GpsTracker gt = new GpsTracker(getApplicationContext());
                Location l = gt.getLocation();
                if( l == null){
                    Toast.makeText(getApplicationContext(),"GPS unable to get Value",Toast.LENGTH_SHORT).show();
                }else {
                    lat = l.getLatitude();
                    z = lat;
                    lon = l.getLongitude();
                    y = lon;
                    urlll = "https://b2148b6d.ngrok.io/weather/location/" + (int)lat + "-" + (int)lon;
                    Toast.makeText(getApplicationContext(),"GPS Lat = "+lat+"\n lon = "+lon,Toast.LENGTH_SHORT).show();
                    fetchData process = new fetchData(urlll);
                    process.execute();
                }
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnLoc.performClick();
            }
        }, 1000);
        btnLoc.setPressed(true);
    }
    }

