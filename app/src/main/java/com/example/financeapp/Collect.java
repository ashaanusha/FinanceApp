package com.example.financeapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Collect extends AppCompatActivity {
    String number1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ImageView call=findViewById(R.id.call);
        ImageView whatsapp=findViewById(R.id.whatsApp);
       number1 = getIntent().getStringExtra("number");
        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isPermissionGranted()) {

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + number1));
                    if (ActivityCompat.checkSelfPermission(Collect.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    }
                    startActivity(callIntent);

                } else {
                    Toast.makeText(Collect.this, "permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPermissionGranted()) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    /* sets the desired package for the intent */
                    intent.setPackage("com.whatsapp");
                    intent.setData(Uri.parse(number1));
                    if (ActivityCompat.checkSelfPermission(Collect.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    }
                    startActivity(intent);

                } else {
                    Toast.makeText(Collect.this, "permission denied", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if ((checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED )
                    && (checkSelfPermission(android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED)
                    && (checkSelfPermission(Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED)
                    &&(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)) {
                Log.v("TAG", "Permission is granted");
                return true;
            } else {

                Log.v("TAG", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.CAMERA,Manifest.permission.SEND_SMS}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG", "below 23");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }     // other 'case' lines to check for other
        // permissions this app might request
    }
    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

        }
    }
}
