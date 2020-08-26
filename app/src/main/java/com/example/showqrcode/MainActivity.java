package com.example.showqrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    String url = "https://www.google.com";

    int qrcodeSize = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            BarcodeEncoder be = new BarcodeEncoder();

            Bitmap bm = be.encodeBitmap(url, BarcodeFormat.QR_CODE, qrcodeSize, qrcodeSize);

            ImageView iv = findViewById(R.id.imageView);
            iv.setImageBitmap(bm);
        } catch (WriterException we){
            we.printStackTrace();
        }
    }
}
