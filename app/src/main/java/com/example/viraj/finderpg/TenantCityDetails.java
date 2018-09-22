package com.example.viraj.finderpg;
/*
* Displays list of all PG's in that city
* TODO
* Populate actual details from given extra city via intent from TenantRegister activity
* */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TenantCityDetails extends AppCompatActivity {
    Button openMapsActivity,backToTenantRegister;
    private String city;
    TextView cityName;
    ListView pGListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_city_details);

        city=getIntent().getStringExtra("city");

        cityName = (TextView)findViewById(R.id.cityName);
        openMapsActivity = (Button)findViewById(R.id.openMapsActivity);
        backToTenantRegister=findViewById(R.id.backToTenantRegister);
        pGListView = (ListView)findViewById(R.id.pGListView);

        cityName.setText(city);

        List<HostelItem> pGList = new ArrayList<>();

        pGList.add(new HostelItem("Maharashtra Institute of Technology Kothrud Boys Hostel","Shared","More Vidyalaya",4000,3));
        pGList.add(new HostelItem("Generic PG","Shared","Sneha Paradise",6000,2));
        pGList.add(new HostelItem("Generic PG Dwitiya","Shared","Kothrud",6500,2));

        HostelAdapter pGListAdapter = new HostelAdapter(this,R.layout.hostel_list_item, pGList);
        pGListView.setAdapter(pGListAdapter);

        openMapsActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(TenantCityDetails.this,MapsActivity.class);
                        i.putExtra("city",city);

                        startActivity(i);
                    }
                }
        );

        backToTenantRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(TenantCityDetails.this,TenantRegister.class);
                        startActivity(i);
                    }
                }
        );

        pGListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(TenantCityDetails.this,PGDetailActivity.class);
                        HostelItem demo = (HostelItem)parent.getItemAtPosition(position);
                        i.putExtra("PGName",demo.getName());
                        startActivity(i);
                    }
                }
        );

    }
}
