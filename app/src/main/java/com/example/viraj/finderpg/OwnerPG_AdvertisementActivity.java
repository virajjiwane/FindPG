package com.example.viraj.finderpg;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class OwnerPG_AdvertisementActivity extends AppCompatActivity {
    /*
    Declarations
     */
    ImageButton backToOwnerPGRegistrationActivity;
    ProgressBar progressBar6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_pg__advertisement);

        /*
        Linking variable to view
         */
        backToOwnerPGRegistrationActivity = findViewById(R.id.backToOwnerPGRegisterActivity);
        progressBar6 = findViewById(R.id.progressBar6);

        /*
        Initializing activity
         */
        progressBar6.setProgress(100);


        /*
        backToOwnerPGRegistrationActivity switches back to OwnerPGRegistrationActivity
         */
        backToOwnerPGRegistrationActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(OwnerPG_AdvertisementActivity.this,OwnerPGRegisterActivity.class);
                        startActivity(i);
                    }
                }
        );

    }
}
