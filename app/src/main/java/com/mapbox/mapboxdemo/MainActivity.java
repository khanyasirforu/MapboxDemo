package com.mapbox.mapboxdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.PolylineOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.MapboxMapOptions;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private View paddingView=null;
    private MapboxMap mapboxMap;
    private LatLngBounds latLngBounds;
    private List<LatLng> latLngs1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paddingView=findViewById(R.id.padding_view);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        SupportMapFragment mapFragment = SupportMapFragment.newInstance(createFragmentOptions());

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map, mapFragment, "com.mapbox.map")
                .addToBackStack("com.mapbox.map")
                .commit();

        mapFragment.getMapAsync(this);



    }


    private MapboxMapOptions createFragmentOptions() {
        LatLng latLng = new LatLng(28.612461, 77.234509);
        return new MapboxMapOptions()
                .zoomGesturesEnabled(true)
                .scrollGesturesEnabled(true)
                .tiltGesturesEnabled(true)
                .rotateGesturesEnabled(true)
                .textureMode(false)
                .minZoomPreference(4)
                .maxZoomPreference(18.5)
                .camera(new CameraPosition.Builder()
                        .target(latLng)
                        .zoom(11)
                        .build());
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        this.mapboxMap=mapboxMap;
        mapboxMap.setStyle(Style.MAPBOX_STREETS);

         latLngs1=getLatLngs();
         latLngBounds=  new LatLngBounds.Builder().includes(latLngs1).build();

    }

    public void setPadding(View view){
        mapboxMap.setPadding(0,0,0,800);


        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
          RelativeLayout.LayoutParams.WRAP_CONTENT,
          RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0,0,0,800);
        paddingView.setLayoutParams(params);
    }



    public void addMarker(View view){
        mapboxMap.addMarker(new MarkerOptions().position(latLngBounds.getCenter()));
      mapboxMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngBounds.getCenter(),14));
    }

    public void clear(View view){
        mapboxMap.clear();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
          RelativeLayout.LayoutParams.WRAP_CONTENT,
          RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(0,0,0,0);
        paddingView.setLayoutParams(params);

    }

    public void addPolyline(View view){

        mapboxMap.addPolyline(new PolylineOptions().addAll(latLngs1).color(Color.BLUE).width(6.0f));
        mapboxMap.addMarker(new MarkerOptions().position(latLngBounds.getCenter()));

        mapboxMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds,0,0,0,0));
    }


    List<LatLng> getLatLngs(){
        String json="[{\"altitude\":0.0,\"latitude\":12.95046,\"longitude\":77.64157},{\"altitude\":0.0,\"latitude\":12.9505,\"longitude\":77.6414},{\"altitude\":0.0,\"latitude\":12.95056,\"longitude\":77.64138},{\"altitude\":0.0,\"latitude\":12.95065,\"longitude\":77.64136},{\"altitude\":0.0,\"latitude\":12.95065,\"longitude\":77.64124},{\"altitude\":0.0,\"latitude\":12.95061,\"longitude\":77.64113},{\"altitude\":0.0,\"latitude\":12.95048,\"longitude\":77.64109},{\"altitude\":0.0,\"latitude\":12.95039,\"longitude\":77.64101},{\"altitude\":0.0,\"latitude\":12.95036,\"longitude\":77.64096},{\"altitude\":0.0,\"latitude\":12.95035,\"longitude\":77.64088},{\"altitude\":0.0,\"latitude\":12.95035,\"longitude\":77.64085},{\"altitude\":0.0,\"latitude\":12.95048,\"longitude\":77.6407},{\"altitude\":0.0,\"latitude\":12.95059,\"longitude\":77.64059},{\"altitude\":0.0,\"latitude\":12.95097,\"longitude\":77.64022},{\"altitude\":0.0,\"latitude\":12.95114,\"longitude\":77.6401},{\"altitude\":0.0,\"latitude\":12.95134,\"longitude\":77.64001},{\"altitude\":0.0,\"latitude\":12.95142,\"longitude\":77.63993},{\"altitude\":0.0,\"latitude\":12.95144,\"longitude\":77.63987},{\"altitude\":0.0,\"latitude\":12.95146,\"longitude\":77.63979},{\"altitude\":0.0,\"latitude\":12.95147,\"longitude\":77.63975},{\"altitude\":0.0,\"latitude\":12.95096,\"longitude\":77.63952},{\"altitude\":0.0,\"latitude\":12.95067,\"longitude\":77.63939},{\"altitude\":0.0,\"latitude\":12.9504,\"longitude\":77.63928},{\"altitude\":0.0,\"latitude\":12.95016,\"longitude\":77.63924},{\"altitude\":0.0,\"latitude\":12.94992,\"longitude\":77.63927},{\"altitude\":0.0,\"latitude\":12.94974,\"longitude\":77.63933},{\"altitude\":0.0,\"latitude\":12.94949,\"longitude\":77.63948},{\"altitude\":0.0,\"latitude\":12.94933,\"longitude\":77.63962},{\"altitude\":0.0,\"latitude\":12.94892,\"longitude\":77.64006},{\"altitude\":0.0,\"latitude\":12.94854,\"longitude\":77.64052},{\"altitude\":0.0,\"latitude\":12.9484,\"longitude\":77.64066},{\"altitude\":0.0,\"latitude\":12.94818,\"longitude\":77.64079},{\"altitude\":0.0,\"latitude\":12.94799,\"longitude\":77.64085},{\"altitude\":0.0,\"latitude\":12.94775,\"longitude\":77.6409},{\"altitude\":0.0,\"latitude\":12.9476,\"longitude\":77.6409},{\"altitude\":0.0,\"latitude\":12.94732,\"longitude\":77.64088},{\"altitude\":0.0,\"latitude\":12.94721,\"longitude\":77.64083},{\"altitude\":0.0,\"latitude\":12.94701,\"longitude\":77.64072},{\"altitude\":0.0,\"latitude\":12.94623,\"longitude\":77.64024},{\"altitude\":0.0,\"latitude\":12.946,\"longitude\":77.6401},{\"altitude\":0.0,\"latitude\":12.94605,\"longitude\":77.64001},{\"altitude\":0.0,\"latitude\":12.9467,\"longitude\":77.64041},{\"altitude\":0.0,\"latitude\":12.94719,\"longitude\":77.64067},{\"altitude\":0.0,\"latitude\":12.94735,\"longitude\":77.64075},{\"altitude\":0.0,\"latitude\":12.94747,\"longitude\":77.64077},{\"altitude\":0.0,\"latitude\":12.94773,\"longitude\":77.64077},{\"altitude\":0.0,\"latitude\":12.94798,\"longitude\":77.64071},{\"altitude\":0.0,\"latitude\":12.9482,\"longitude\":77.64062},{\"altitude\":0.0,\"latitude\":12.94843,\"longitude\":77.64044},{\"altitude\":0.0,\"latitude\":12.94927,\"longitude\":77.6395},{\"altitude\":0.0,\"latitude\":12.94944,\"longitude\":77.63934},{\"altitude\":0.0,\"latitude\":12.94966,\"longitude\":77.63921},{\"altitude\":0.0,\"latitude\":12.95003,\"longitude\":77.6391},{\"altitude\":0.0,\"latitude\":12.95022,\"longitude\":77.63909},{\"altitude\":0.0,\"latitude\":12.95043,\"longitude\":77.63913},{\"altitude\":0.0,\"latitude\":12.95094,\"longitude\":77.63935},{\"altitude\":0.0,\"latitude\":12.95142,\"longitude\":77.6396},{\"altitude\":0.0,\"latitude\":12.95237,\"longitude\":77.64018},{\"altitude\":0.0,\"latitude\":12.95395,\"longitude\":77.64106},{\"altitude\":0.0,\"latitude\":12.95419,\"longitude\":77.64118},{\"altitude\":0.0,\"latitude\":12.95439,\"longitude\":77.64123},{\"altitude\":0.0,\"latitude\":12.95456,\"longitude\":77.64127},{\"altitude\":0.0,\"latitude\":12.95542,\"longitude\":77.64129},{\"altitude\":0.0,\"latitude\":12.95659,\"longitude\":77.64133},{\"altitude\":0.0,\"latitude\":12.95774,\"longitude\":77.6413},{\"altitude\":0.0,\"latitude\":12.95798,\"longitude\":77.6413},{\"altitude\":0.0,\"latitude\":12.95818,\"longitude\":77.64131},{\"altitude\":0.0,\"latitude\":12.95832,\"longitude\":77.64128},{\"altitude\":0.0,\"latitude\":12.95899,\"longitude\":77.64131},{\"altitude\":0.0,\"latitude\":12.95971,\"longitude\":77.64139},{\"altitude\":0.0,\"latitude\":12.95998,\"longitude\":77.64144},{\"altitude\":0.0,\"latitude\":12.9604,\"longitude\":77.64152},{\"altitude\":0.0,\"latitude\":12.96036,\"longitude\":77.64173},{\"altitude\":0.0,\"latitude\":12.95994,\"longitude\":77.64162},{\"altitude\":0.0,\"latitude\":12.9597,\"longitude\":77.64157},{\"altitude\":0.0,\"latitude\":12.959,\"longitude\":77.64152},{\"altitude\":0.0,\"latitude\":12.95835,\"longitude\":77.64147},{\"altitude\":0.0,\"latitude\":12.95824,\"longitude\":77.64142},{\"altitude\":0.0,\"latitude\":12.95813,\"longitude\":77.64141},{\"altitude\":0.0,\"latitude\":12.95767,\"longitude\":77.64138},{\"altitude\":0.0,\"latitude\":12.95727,\"longitude\":77.64139},{\"altitude\":0.0,\"latitude\":12.95698,\"longitude\":77.64143},{\"altitude\":0.0,\"latitude\":12.95635,\"longitude\":77.64144},{\"altitude\":0.0,\"latitude\":12.95535,\"longitude\":77.6414},{\"altitude\":0.0,\"latitude\":12.95451,\"longitude\":77.64135},{\"altitude\":0.0,\"latitude\":12.95429,\"longitude\":77.64132},{\"altitude\":0.0,\"latitude\":12.95417,\"longitude\":77.64129},{\"altitude\":0.0,\"latitude\":12.95339,\"longitude\":77.64087},{\"altitude\":0.0,\"latitude\":12.95283,\"longitude\":77.64056},{\"altitude\":0.0,\"latitude\":12.95198,\"longitude\":77.64006},{\"altitude\":0.0,\"latitude\":12.95176,\"longitude\":77.63991},{\"altitude\":0.0,\"latitude\":12.95165,\"longitude\":77.63992},{\"altitude\":0.0,\"latitude\":12.95152,\"longitude\":77.63997},{\"altitude\":0.0,\"latitude\":12.95134,\"longitude\":77.64008},{\"altitude\":0.0,\"latitude\":12.95111,\"longitude\":77.64028},{\"altitude\":0.0,\"latitude\":12.95102,\"longitude\":77.64043},{\"altitude\":0.0,\"latitude\":12.95094,\"longitude\":77.64062},{\"altitude\":0.0,\"latitude\":12.95089,\"longitude\":77.6408},{\"altitude\":0.0,\"latitude\":12.95086,\"longitude\":77.64087},{\"altitude\":0.0,\"latitude\":12.95064,\"longitude\":77.64095},{\"altitude\":0.0,\"latitude\":12.95017,\"longitude\":77.64117},{\"altitude\":0.0,\"latitude\":12.9501,\"longitude\":77.64123},{\"altitude\":0.0,\"latitude\":12.94962,\"longitude\":77.64185},{\"altitude\":0.0,\"latitude\":12.94957,\"longitude\":77.64191},{\"altitude\":0.0,\"latitude\":12.94904,\"longitude\":77.64249},{\"altitude\":0.0,\"latitude\":12.94887,\"longitude\":77.64267},{\"altitude\":0.0,\"latitude\":12.94877,\"longitude\":77.64278},{\"altitude\":0.0,\"latitude\":12.94873,\"longitude\":77.64288},{\"altitude\":0.0,\"latitude\":12.94872,\"longitude\":77.64294},{\"altitude\":0.0,\"latitude\":12.94874,\"longitude\":77.64297},{\"altitude\":0.0,\"latitude\":12.94875,\"longitude\":77.64301},{\"altitude\":0.0,\"latitude\":12.94879,\"longitude\":77.64308},{\"altitude\":0.0,\"latitude\":12.94888,\"longitude\":77.64317},{\"altitude\":0.0,\"latitude\":12.94897,\"longitude\":77.64325},{\"altitude\":0.0,\"latitude\":12.9491,\"longitude\":77.64331},{\"altitude\":0.0,\"latitude\":12.94956,\"longitude\":77.64342},{\"altitude\":0.0,\"latitude\":12.94962,\"longitude\":77.64344},{\"altitude\":0.0,\"latitude\":12.94956,\"longitude\":77.64342},{\"altitude\":0.0,\"latitude\":12.9491,\"longitude\":77.64331},{\"altitude\":0.0,\"latitude\":12.9489,\"longitude\":77.64321},{\"altitude\":0.0,\"latitude\":12.94883,\"longitude\":77.64319},{\"altitude\":0.0,\"latitude\":12.94865,\"longitude\":77.64312},{\"altitude\":0.0,\"latitude\":12.94858,\"longitude\":77.6431},{\"altitude\":0.0,\"latitude\":12.94856,\"longitude\":77.64307},{\"altitude\":0.0,\"latitude\":12.94854,\"longitude\":77.64299},{\"altitude\":0.0,\"latitude\":12.94858,\"longitude\":77.64292},{\"altitude\":0.0,\"latitude\":12.94862,\"longitude\":77.64291},{\"altitude\":0.0,\"latitude\":12.9487,\"longitude\":77.64279},{\"altitude\":0.0,\"latitude\":12.94897,\"longitude\":77.64246},{\"altitude\":0.0,\"latitude\":12.94954,\"longitude\":77.64186},{\"altitude\":0.0,\"latitude\":12.95029,\"longitude\":77.64092},{\"altitude\":0.0,\"latitude\":12.95059,\"longitude\":77.64059},{\"altitude\":0.0,\"latitude\":12.95097,\"longitude\":77.64022},{\"altitude\":0.0,\"latitude\":12.95114,\"longitude\":77.6401},{\"altitude\":0.0,\"latitude\":12.95134,\"longitude\":77.64001},{\"altitude\":0.0,\"latitude\":12.95142,\"longitude\":77.63993},{\"altitude\":0.0,\"latitude\":12.95144,\"longitude\":77.63987},{\"altitude\":0.0,\"latitude\":12.95146,\"longitude\":77.63979},{\"altitude\":0.0,\"latitude\":12.95147,\"longitude\":77.63975},{\"altitude\":0.0,\"latitude\":12.95096,\"longitude\":77.63952},{\"altitude\":0.0,\"latitude\":12.95067,\"longitude\":77.63939},{\"altitude\":0.0,\"latitude\":12.9504,\"longitude\":77.63928},{\"altitude\":0.0,\"latitude\":12.95016,\"longitude\":77.63924},{\"altitude\":0.0,\"latitude\":12.94992,\"longitude\":77.63927},{\"altitude\":0.0,\"latitude\":12.94974,\"longitude\":77.63933},{\"altitude\":0.0,\"latitude\":12.94949,\"longitude\":77.63948},{\"altitude\":0.0,\"latitude\":12.94933,\"longitude\":77.63962},{\"altitude\":0.0,\"latitude\":12.94892,\"longitude\":77.64006},{\"altitude\":0.0,\"latitude\":12.94854,\"longitude\":77.64052},{\"altitude\":0.0,\"latitude\":12.9484,\"longitude\":77.64066},{\"altitude\":0.0,\"latitude\":12.94818,\"longitude\":77.64079},{\"altitude\":0.0,\"latitude\":12.94799,\"longitude\":77.64085},{\"altitude\":0.0,\"latitude\":12.94775,\"longitude\":77.6409},{\"altitude\":0.0,\"latitude\":12.9476,\"longitude\":77.6409},{\"altitude\":0.0,\"latitude\":12.94732,\"longitude\":77.64088},{\"altitude\":0.0,\"latitude\":12.94717,\"longitude\":77.64081},{\"altitude\":0.0,\"latitude\":12.94694,\"longitude\":77.64068},{\"altitude\":0.0,\"latitude\":12.946,\"longitude\":77.6401},{\"altitude\":0.0,\"latitude\":12.94506,\"longitude\":77.63954},{\"altitude\":0.0,\"latitude\":12.94257,\"longitude\":77.63801}]";
        List<LatLng> latLngs=new Gson().fromJson(json,new TypeToken<List<LatLng>>(){}.getType());
        return latLngs;
    }
}
