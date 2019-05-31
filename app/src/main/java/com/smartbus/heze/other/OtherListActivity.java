package com.smartbus.heze.other;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.smartbus.heze.R;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.other.activity.AdvertActivity;
import com.smartbus.heze.other.activity.ICMSActivity;
import com.smartbus.heze.other.activity.LostActivity;
import com.smartbus.heze.other.activity.SaferActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtherListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_otherlist;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                intent = new Intent(this,ICMSActivity.class);
                startActivity(intent);
                break;
            case R.id.rb2:
                intent = new Intent(this,LostActivity.class);
                startActivity(intent);
                break;
            case R.id.rb3:
                intent = new Intent(this,SaferActivity.class);
                startActivity(intent);
                break;
            case R.id.rb4:
                intent = new Intent(this,AdvertActivity.class);
                startActivity(intent);
                break;
        }
    }
}
