package com.example.viraj.finderpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton tenant, owner, register;
    RadioGroup identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        identity = (RadioGroup) findViewById(R.id.radioGroupMain);
        tenant = (RadioButton) findViewById(R.id.tenant_m);
        owner = (RadioButton) findViewById(R.id.owner_m);
        register = (RadioButton) findViewById(R.id.register_m);

        /**
         * Exit Button code
         */
        Button exit = (Button) findViewById(R.id.exit_m);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        /**
         * Next Button which routes to next activity depending on the radio button selected
         */
        Button next = (Button) findViewById(R.id.next_m);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tenant.isChecked()) {
                    startActivity(new Intent(MainActivity.this, TenantRegister.class));
                    finish();
                }

                if(owner.isChecked()) {
                    startActivity(new Intent(MainActivity.this, LoginOwnerActivity.class));
                    finish();
                }

                if(register.isChecked()) {
                    startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                    finish();
                }

            }
        });

    }
}
