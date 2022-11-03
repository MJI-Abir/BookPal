package com.app.hotel.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.hotel.R;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_DURATION;
    Animation topAnim,bottomAnim;
    ImageView image;
    TextView logo,slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_splash);

        image = findViewById(R.id.imageView2);
        logo = findViewById(R.id.bookpaltv);
        slogan = findViewById(R.id.slogan);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
//Set animation to elements
        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);

        new Handler().postDelayed(() -> {
            startActivity(intent);
            finish();
        },4000);
    }

}