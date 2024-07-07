package com.dimasadjie.worldtour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainMenus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menus);
        ImageView imageView = findViewById(R.id.dimas);
        Glide.with(this)
                .load(R.drawable.dimas)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);

        ImageView imageViewig = findViewById(R.id.instagram);
        ImageView imageViewtw = findViewById(R.id.twitter);
        ImageView imageViewfb = findViewById(R.id.facebook);
        imageViewig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.instagram.com/dimasadjee?igsh=MW42MmVvajZ5ZjNmbg==";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        imageViewtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://x.com/Dmsadj_10?t=vFE-_FEaEfUH4MLMEMm3SQ&s=09";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        imageViewfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/profile.php?id=100009828677000";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
    public void Paris(View view){
        Intent intent = new Intent(MainMenus.this, Paris.class);
        startActivity(intent);
    }
    public void Bali(View view){
        Intent intent = new Intent(MainMenus.this, Bali.class);
        startActivity(intent);
    }
    public void Singapore(View view){
        Intent intent = new Intent(MainMenus.this, Singapore.class);
        startActivity(intent);
    }
    public void Roma(View view){
        Intent intent = new Intent(MainMenus.this, Roma.class);
        startActivity(intent);
    }
    public void Mahal(View view){
        Intent intent = new Intent(MainMenus.this, Mahal.class);
        startActivity(intent);
    }
    public void Pisa(View view){
        Intent intent = new Intent(MainMenus.this, Pisa.class);
        startActivity(intent);
    }
    public void Sydney(View view){
        Intent intent = new Intent(MainMenus.this, Sydney.class);
        startActivity(intent);
    }
    public void China(View view){
        Intent intent = new Intent(MainMenus.this, China.class);
        startActivity(intent);
    }



}