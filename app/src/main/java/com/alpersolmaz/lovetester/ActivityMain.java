package com.alpersolmaz.lovetester;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide(); // Hide action bar.

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); // Hide status bar.

        ImageView splash_image = (ImageView) findViewById(R.id.splash_image); // Splash image that appears when you open the app.

        // Add a zoom animation
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_zoom_animation);
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        splash_image.setAnimation(animation);
        animation.start();
        /////////////////////////////////////


        // Switch to ActivityTesting page when the zoom animation is over.
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                finish();
                Intent transition = new Intent(getApplicationContext(), ActivityTesting.class);
                startActivity(transition);
            }
        }, 2750);
        /////////////////////////////////////


    }
}
