package com.example.viraj.finderpg;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OwnerHomeActivity extends AppCompatActivity {
    /*
     * Declarations
     * */
    FloatingActionButton toOwnerPGRegisterActivity;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_home);

        /*
        * Link variables with Views
        * */
        toOwnerPGRegisterActivity = findViewById(R.id.toOwnerPGRegisterActivity);

        /*
        toOwnerPGRegisterActivity switches to OwnerPGRegisterActivity
         */
        toOwnerPGRegisterActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(OwnerHomeActivity.this,OwnerPGRegisterActivity.class);
                        startActivity(i);
                    }
                }
        );
    }
}
