package com.smartbus.heze.checkup;

import android.os.Bundle;

import com.smartbus.heze.R;
import com.smartbus.heze.http.base.BaseActivity;

import butterknife.ButterKnife;

public class RCJCActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_rcjc;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
