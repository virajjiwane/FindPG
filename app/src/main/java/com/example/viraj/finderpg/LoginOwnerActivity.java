package com.example.viraj.finderpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginOwnerActivity extends AppCompatActivity {

    //Declarations
    Button loginToOwnerHomeActivity,backToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_owner);

        /*
        * Linking variables by Views
        * */
        backToMainActivity = (Button) findViewById(R.id.backToMainActivity);
        loginToOwnerHomeActivity = findViewById(R.id.loginToOwnerHomeActivity);

        /**
         * Back button which switches back to MainActivity
         */
        backToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(LoginOwnerActivity.this, MainActivity.class));
              finish();
            }
        });

        /*
        * loginToOwnerHomeActivity button which switches to MainActivityOwnerHomeActivity
        **/
        loginToOwnerHomeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginOwnerActivity.this,OwnerHomeActivity.class);
                /*
                * Put extras here
                * */

                startActivity(i);
            }
        });

    }
}
