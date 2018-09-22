package com.example.viraj.finderpg;
/*Google maps activity to display TenantCityDetailsActivity information in map format
* Basically plot all PG's on map in given locality/city/current location
* It gets Extras from TenantRegister using intent
* Extra contains only city name
* TODO
* Get LatLng of all PG's in that city
* Try animate camera
* Fine tune zoom
* current location*/
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button backToTenantCityDetails,backToTenantRegisterfromMap;
    private String city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        backToTenantCityDetails = (Button)findViewById(R.id.backToTenantCityDetails);
        backToTenantRegisterfromMap= findViewById(R.id.backToTenantRegisterfromMap);

        backToTenantCityDetails.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MapsActivity.this,TenantCityDetails.class);
                        i.putExtra("city",city);
                        startActivity(i);
                    }
                }
        );

        backToTenantRegisterfromMap.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MapsActivity.this,TenantRegister.class);
                        startActivity(i);
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
        city = getIntent().getStringExtra("city").toLowerCase();
        /*
        * Get all PG's in city from database*/

        Geocoder geocoder = new Geocoder(MapsActivity.this);
        List<Address> list = new ArrayList<>();
        /*
        * Just random locations in pune.
        * Has no connection with any PG on TenantCityDetailsActivity
        * Populate demo with all PG's location in city/locality/current location.
        *
        * */
        LatLng[] demo = {new LatLng(18.512661, 73.925150),new LatLng(18.505818, 73.927105),new LatLng(18.495489, 73.835056)};

        try{
            list = geocoder.getFromLocationName(city,1);
        }catch(IOException e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
        }

        LatLng cityLatlng = new LatLng(list.get(0).getLatitude(),list.get(0).getLongitude());

        for(LatLng l : demo){
            mMap.addMarker(new MarkerOptions().position(l).title(city).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))) ;
        }

        mMap.addMarker(new MarkerOptions().position(cityLatlng).title(city).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))) ;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cityLatlng,12f));



    }
}
