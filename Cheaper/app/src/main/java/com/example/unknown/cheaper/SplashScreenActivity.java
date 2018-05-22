package com.example.unknown.cheaper;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ImageView logo_imageView;
    long animation=2000;
    ImageView bagimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        bagimg=(ImageView)findViewById(R.id.bag_Imageview);
        ObjectAnimator objectAnimatory=ObjectAnimator.ofFloat(bagimg,"y",200f);
        objectAnimatory.setDuration(animation);

        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(objectAnimatory);
        animatorSet.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreenActivity.this,LoginActivity.class);
                SplashScreenActivity.this.startActivity(intent);
                SplashScreenActivity.this.finish();

            }
        },2500);

    }
}
