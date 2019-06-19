package com.smartbus.heze.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartbus.heze.R;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimulateResultActivity extends BaseActivity {

    String num, name;
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvPass)
    TextView tvPass;
    @BindView(R.id.tvScore)
    TextView tvScore;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        num = intent.getStringExtra("num");
        name = intent.getStringExtra("name");

        tvPass.setText(name);
        tvScore.setText(num);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_simulate_result;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
