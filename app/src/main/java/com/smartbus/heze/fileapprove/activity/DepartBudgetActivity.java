package com.smartbus.heze.fileapprove.activity;

import android.os.Bundle;

import com.smartbus.heze.R;
import com.smartbus.heze.http.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * 各部门的预算单
 */
public class DepartBudgetActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_depart_budget;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
