package com.smartbus.heze.fileapprove;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.activity.BorrowAccidentActivity;
import com.smartbus.heze.fileapprove.activity.CurrencyAccidentActivity;
import com.smartbus.heze.fileapprove.activity.DepartBudgetActivity;
import com.smartbus.heze.fileapprove.activity.DocumentLZActivity;
import com.smartbus.heze.fileapprove.activity.FileCirculateActivity;
import com.smartbus.heze.fileapprove.activity.HuiQianActivity;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FileMainActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.ll5)
    LinearLayout ll5;
    @BindView(R.id.ll6)
    LinearLayout ll6;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_file_main;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.ll1, R.id.ll2, R.id.ll3, R.id.ll4, R.id.ll5, R.id.ll6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                intent = new Intent(this, DepartBudgetActivity.class);
                startActivity(intent);
                break;
            case R.id.ll2:
                intent = new Intent(this, BorrowAccidentActivity.class);
                startActivity(intent);
                break;
            case R.id.ll3:
                intent = new Intent(this, CurrencyAccidentActivity.class);
                startActivity(intent);
                break;
            case R.id.ll4:
                intent = new Intent(this, HuiQianActivity.class);
                startActivity(intent);
                break;
            case R.id.ll5:
                intent = new Intent(this, FileCirculateActivity.class);
                startActivity(intent);
                break;
            case R.id.ll6:
                intent = new Intent(this, DocumentLZActivity.class);
                startActivity(intent);
                break;
        }
    }
}
