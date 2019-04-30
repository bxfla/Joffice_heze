package com.smartbus.heze.welcome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.smartbus.heze.R;
import com.smartbus.heze.http.views.StatusBarUtils;

import org.greenrobot.eventbus.EventBus;

public class WelcomeActivity extends AppCompatActivity{
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new StatusBarUtils().setWindowStatusBarColor(WelcomeActivity.this, R.color.white);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                finish();
            }
        },1500);
    }



    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
    }
}
