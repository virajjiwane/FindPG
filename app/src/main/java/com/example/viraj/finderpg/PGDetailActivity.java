package com.example.viraj.finderpg;
/*
* This activity deals with displaying PG information*/
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PGDetailActivity extends AppCompatActivity {
    Button call,openMapsActivityFromHostelDetail;
    String phone,PGName;
    TextView pGNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgdetail);

        pGNameTextView = findViewById(R.id.pGNameTextView);
        call = (Button)findViewById(R.id.call);
        openMapsActivityFromHostelDetail=findViewById(R.id.openMapsActivityFromHostelDetail);

        /*
        * get pg from intent by PG_ID
        * retrieve data pg database via PG_ID
        * */

        PGName=getIntent().getStringExtra("PGName");

        pGNameTextView.setText(PGName);

        /*
        * Call Dialer
        * */
        phone = "9595808478";
        call.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_DIAL);
                        i.setData(Uri.parse("tel:"+phone));
                        startActivity(i);
                    }
                }
        );

        openMapsActivityFromHostelDetail.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(PGDetailActivity.this,PGDetailMap.class);

                        /*TODO
                        * Put extras here
                        * pg location
                        * this activity
                        * do old school housekeeping in PGDetailMap zoom coloring marker
                        */

                        i.putExtra("PGName",PGName);

                        startActivity(i);

                    }
                }
        );

    }
}
