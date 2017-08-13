package com.example.roman.progressbaranimated;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    ObjectAnimator progressAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        initProgressbar();
    }

    private void initProgressbar() {
        progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", 0, 10000);
        progressAnimator.setDuration(30000);
        progressAnimator.setInterpolator(new LinearInterpolator());
    }

    private void startAnimation(){
        progressAnimator.start();
    }

    private void pauseAnimator(){
        progressAnimator.pause();
    }

    private void resumeAnimator(){
        progressAnimator.resume();
    }

    public void onClickMe(View view) {
        if(!view.isActivated()) {
            if(!progressAnimator.isStarted()) {
                startAnimation();
            } else {
                resumeAnimator();
            }
        } else {
            pauseAnimator();
        }
        view.setActivated(!view.isActivated());
    }
}
