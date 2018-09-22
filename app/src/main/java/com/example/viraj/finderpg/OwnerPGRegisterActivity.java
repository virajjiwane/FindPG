package com.example.viraj.finderpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class OwnerPGRegisterActivity extends AppCompatActivity {
    /*
    Declarations
     */
    Button toOwnerPGAmenityActivity;
    ImageButton backToOwnerHomeActivity,ownerMapButton;
    EditText nameOfPG,editTextAddress,noOfRooms,noOfBeds,editTextcontact,editTextPrice;
    RadioButton radioButtonBoys,radioButtonGirls;
    RadioGroup ownerRadioGroup;
    Switch switchContactEditable,switchCotBased;
    ProgressBar progressBar;

    String ownerPhoneNo,nameofpg,pgaddress,noofrooms,noofbeds,contact,price;
    Boolean forboys,forgirls,cotbased;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_pgregister);

        /*
        Definations
         */
        ownerPhoneNo="9595848478";//Owner's contact no provided at time of registration.


        /*
        Linking variables to Views
         */
        toOwnerPGAmenityActivity = findViewById(R.id.toOwnerPGAmenityActivity);
        backToOwnerHomeActivity  = findViewById(R.id.backToOwnerHomeActivity);
        nameOfPG = findViewById(R.id.nameOfPG);
        editTextAddress = findViewById(R.id.editTextAddress);
        noOfBeds = findViewById(R.id.noOfBeds);
        noOfRooms = findViewById(R.id.noOfRooms);
        editTextcontact = findViewById(R.id.contact);
        editTextPrice = findViewById(R.id.price);
        ownerMapButton = findViewById(R.id.ownerMapButton);
        ownerRadioGroup = findViewById(R.id.ownerRadioGroup);
        radioButtonBoys = findViewById(R.id.radioButtonBoys);
        radioButtonGirls = findViewById(R.id.radioButtonGirls);
        progressBar = findViewById(R.id.progressBar);
        switchContactEditable = findViewById(R.id.switchContactEditable);
        switchCotBased = findViewById(R.id.switchCotBased);


         /*
        Initializing activity
         */
         progressBar.setProgress(0);
        editTextcontact.setHint(ownerPhoneNo);
        editTextcontact.setEnabled(!switchContactEditable.isChecked());


        /*
        toOwnerPGAmenityActivity switches to OwnerAmenityActivity
         */
        toOwnerPGAmenityActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Intent i = new Intent(OwnerPGRegisterActivity.this,OwnerPGAmenityActivity.class);
                       i.putExtra("",);
                       startActivity(i);
                    }
                }
        );



        /*
        backToOwnerHomeActivity switches back to OwnerHomeActivity
         */
        backToOwnerHomeActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(OwnerPGRegisterActivity.this,OwnerHomeActivity.class);
                        startActivity(i);
                    }
                }
        );

        switchContactEditable.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (!switchContactEditable.isChecked()) {
                            editTextcontact.setHint("Contact No");
                            editTextcontact.setEnabled(true);
                            switchContactEditable.setText("No");
                        }
                        else{
                            editTextcontact.setHint(ownerPhoneNo);
                            editTextcontact.setText("");
                            editTextcontact.setEnabled(false);
                            switchContactEditable.setText("Yes");
                        }
                    }
                }
        );

        switchCotBased.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!switchCotBased.isChecked()) {
                            switchCotBased.setText("No ");
                        }
                        else{
                            switchCotBased.setText("Yes ");
                        }
                    }
                }
        );

    }
}
