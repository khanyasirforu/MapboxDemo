package com.mapbox.mapboxdemo;

import android.app.Application;

import com.mapbox.mapboxsdk.Mapbox;

public class MapApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Mapbox.getInstance(getApplicationContext(), );

    }
}
