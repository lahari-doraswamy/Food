package com.example.evaluationtask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView text1,text2;
    private int count =0;
    Handler h =new Handler();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.SYSTEM_UI_FLAG_LAYOUT_STABLE
        |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        |View.SYSTEM_UI_FLAG_FULLSCREEN
        |View.SYSTEM_UI_FLAG_IMMERSIVE);
        setContentView(R.layout.activity_main);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        ImageView foodpie = findViewById(R.id.FoodPie);
        Animation logoAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom_animation);

        Animation text1Animaion = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_animation);

 foodpie.startAnimation(logoAnimation);
logoAnimation.setAnimationListener(new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {
        foodpie.setVisibility(View.VISIBLE);
        foodpie.startAnimation(logoAnimation);

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        text1.setVisibility(View.VISIBLE);
        text1.startAnimation(text1Animaion);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
});
text1Animaion.setAnimationListener(new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {
        text2.setVisibility(View.VISIBLE);
        final String animateTxt = text2.getText().toString();
        text2.setText("");
        count = 0;
        new CountDownTimer(animateTxt.length()*100,100){

            @Override
            public void onTick(long millisUntilFinished) {
                text2.setText(text2.getText().toString()+animateTxt.charAt(count));
                count++;
            }

            @Override
            public void onFinish() {

            }
        }.start();


    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
});
h.postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent i = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
        finish();
    }
},5000);

    }

}