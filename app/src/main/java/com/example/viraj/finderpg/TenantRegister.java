package com.example.viraj.finderpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class TenantRegister extends AppCompatActivity {

    ListView cityListView;
    Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register);

        cityListView=(ListView)findViewById(R.id.cityListView);
        backToMain=(Button)findViewById(R.id.backToMain);

        String[] cityList={"Pune","Mumbai","Banglore","Hyderabad","Delhi"};
        ListAdapter cityListAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cityList);
        cityListView.setAdapter(cityListAdapter);

        backToMain.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(TenantRegister.this, MainActivity.class));
                        finish();
                    }
                }
        );

        cityListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(TenantRegister.this,TenantCityDetails.class);
                        i.putExtra("city",parent.getItemAtPosition(position).toString());
                        startActivity(i);

                    }
                }
        );

    }
}
