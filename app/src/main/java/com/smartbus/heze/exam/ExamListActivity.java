package com.smartbus.heze.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.smartbus.heze.R;
import com.smartbus.heze.exam.activity.FoundActivity;
import com.smartbus.heze.exam.activity.LearningActivity;
import com.smartbus.heze.exam.activity.OnLineActivity;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExamListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_exam_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                intent = new Intent(this, LearningActivity.class);
                startActivity(intent);
                break;
            case R.id.rb2:
                intent = new Intent(this, OnLineActivity.class);
                startActivity(intent);
                break;
            case R.id.rb3:
                intent = new Intent(this, FoundActivity.class);
                startActivity(intent);
                break;
        }
    }
}
