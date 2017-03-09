package com.julianyepes.copaturistica;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000;
    private ImageView iVector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        iVector=(ImageView)findViewById(R.id.vector);
        Drawable anima=iVector.getDrawable();

        if (anima instanceof Animatable){
            ((Animatable) anima).start();
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent().setClass(SplashActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        };

        Timer timer = new Timer();

        timer.schedule(task,SPLASH_DELAY);

    }
}