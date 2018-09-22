package com.example.viraj.finderpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginTenantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_tenant);

        /**
         * Back button which switches back to MainActivity
         */
        Button back = (Button) findViewById(R.id.backToMainTenant);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginTenantActivity.this, MainActivity.class));
                finish();
            }
        });


    }
}
