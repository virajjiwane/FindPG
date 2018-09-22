package com.example.viraj.finderpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class OwnerPGAmenityActivity extends AppCompatActivity {
    /*
    Declarations
     */
    Button toOwnerPGImageActivity;
    ImageButton backToOwnerPGRegisterActivity;
    ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_pgamenity);

        /*
        Linking variables to views
         */
        toOwnerPGImageActivity = findViewById(R.id.toOwnerPGImageActivity);
        backToOwnerPGRegisterActivity = findViewById(R.id.backToOwnerPGRegisterActivity);
        progressBar2 = findViewById(R.id.progressBar2);

        /*
        Activity initializing
         */
        progressBar2.setProgress(33);

        /*
        toOwnerPGImageActivity switches to OwnerPGImageActivity
         */
        toOwnerPGImageActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(OwnerPGAmenityActivity.this,OwnerPGImageActivity.class);
                        startActivity(i);
                    }
                }
        );

        /*
        backToOwnerPGRegisterActivity switches back to OwnerPGRegisterActivity
         */
        backToOwnerPGRegisterActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(OwnerPGAmenityActivity.this,OwnerPGRegisterActivity.class);
                        startActivity(i);
                    }
                }
        );
    }
}
