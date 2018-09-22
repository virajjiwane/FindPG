package com.example.viraj.finderpg;
/*
* This activity places an marker on map where the pg is located
* TODO
* Make a back button
* Make marker with few details
* Animate camera
* Get extra of longitude and latitude by intent from PGDetailActivity
*
* */
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PGDetailMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button backToPGDetailActivityFromPGDetailMap;
    String PGName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgdetail_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapPGLocation);
        mapFragment.getMapAsync(this);

        backToPGDetailActivityFromPGDetailMap = findViewById(R.id.backToPGDetailActivityFromPGDetailMap);

        backToPGDetailActivityFromPGDetailMap.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(PGDetailMap.this,PGDetailActivity.class);
                        i.putExtra("PGName",PGName);
                    }
                }
        );

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        PGName = getIntent().getStringExtra("PGName");

        Geocoder geocoder = new Geocoder(PGDetailMap.this);

        List<Address> addressList = new ArrayList<>();

        try {
            addressList = geocoder.getFromLocationName(PGName,1);
        } catch (IOException e) {
            Toast.makeText(this,e.toString(), Toast.LENGTH_SHORT).show();
        }

        LatLng cityLatlng = new LatLng(addressList.get(0).getLatitude(),addressList.get(0).getLongitude());

        mMap.addMarker(new MarkerOptions().position(cityLatlng).title(PGName).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))) ;


        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cityLatlng,12f));
    }
}
