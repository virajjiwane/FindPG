package com.example.viraj.finderpg;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.File;
import java.net.URI;

public class OwnerPGImageActivity extends AppCompatActivity {
    /*
    Declarations
     */
    Button toOwnerPG_AdvertisementActivity,ownerPGRoomImageGallery;
    ImageButton backToOwnerAmenityActivity,ownerPGRoomCamera;
    ImageView ownerPGRoomImage;
    ProgressBar progressBar3;

    String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_pgimage);

        /*
        Linking variables to views
         */
        toOwnerPG_AdvertisementActivity = findViewById(R.id.toOwnerPG_AdvertisementActivity);
        backToOwnerAmenityActivity = findViewById(R.id.backToOwnerAmenityActivity);
        ownerPGRoomImageGallery = findViewById(R.id.ownerPGRoomImageGallery);
        ownerPGRoomCamera = findViewById(R.id.ownerPGRoomCamera);
        ownerPGRoomImage = findViewById(R.id.ownerPGRoomImage);
        progressBar3 = findViewById(R.id.progressBar3);

        /*
        Activity initializing
         */
        ownerPGRoomImage.setVisibility(View.GONE);
        progressBar3.setProgress(66);

        /*
        toOwnerPG_AdvertisementActivity switches to OwnerPG_AdvertisementActivity
         */
        toOwnerPG_AdvertisementActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(OwnerPGImageActivity.this, OwnerPG_AdvertisementActivity.class);
                        startActivity(i);
                    }
                }
        );

        /*
        backToOwnerAmenityActivity switches back to OwnerAmenityActivity
         */
        backToOwnerAmenityActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(OwnerPGImageActivity.this,OwnerPGAmenityActivity.class);
                        startActivity(i);
                    }
                }
        );

        /*
        ownerPGRoomCamera opens camera
         */
        ownerPGRoomCamera.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        File imageFile = getFile();
                        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));
                        startActivityForResult(i,1);

                    }
                }
        );

        /*
        Choose from gallery
         */
        ownerPGRoomImageGallery.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                        startActivityForResult(i,2);

                    }
                }
        );
    }



    /*
    Getting result from camera intent
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ownerPGRoomImage.setVisibility(View.VISIBLE);
        if (requestCode == 1 && resultCode == RESULT_OK) {

            //Set image path
            imagePath = "/sdcard/Find_PG/PGRoom.webp";

            //Update ImageView ownerPGRoomImage
            ownerPGRoomImage.setImageDrawable(Drawable.createFromPath(imagePath));
        } else {
            Uri imageUri = data.getData();
            ownerPGRoomImage.setImageURI(imageUri);
        }

    }


    /*
    Get imagePath
     */
    private File getFile(){
        File folder = new File("sdcard/Find_PG");

        if (!folder.exists()) {
            folder.mkdir();
        }

        return new File(folder, "PGRoom.webp");

    }

}
