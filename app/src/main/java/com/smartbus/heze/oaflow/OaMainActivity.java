package com.smartbus.heze.oaflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.smartbus.heze.R;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.oaflow.activity.AddWorkActivity;
import com.smartbus.heze.oaflow.activity.AtWorkActivity;
import com.smartbus.heze.oaflow.activity.OldWorkActivity;
import com.smartbus.heze.oaflow.activity.UserdLeaveActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OaMainActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll8)
    LinearLayout ll8;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.ll5)
    LinearLayout ll5;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_oa_main;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.ll1, R.id.ll8, R.id.ll3, R.id.ll4, R.id.ll5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                intent = new Intent(this, UserdLeaveActivity.class);
                startActivity(intent);
                break;
            case R.id.ll8:
                intent = new Intent(this, AddWorkActivity.class);
                startActivity(intent);
                break;
            case R.id.ll3:
                intent = new Intent(this, OldWorkActivity.class);
                startActivity(intent);
                break;
            case R.id.ll4:
                intent = new Intent(this, AtWorkActivity.class);
                startActivity(intent);
                break;
            case R.id.ll5:
                break;
        }
    }
}
