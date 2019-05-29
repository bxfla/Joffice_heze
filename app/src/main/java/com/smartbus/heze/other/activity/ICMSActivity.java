package com.smartbus.heze.other.activity;

import android.os.Bundle;

import com.smartbus.heze.R;
import com.smartbus.heze.http.base.BaseActivity;

import butterknife.ButterKnife;

public class ICMSActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_icms;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
