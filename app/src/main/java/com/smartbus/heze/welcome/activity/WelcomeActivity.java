package com.smartbus.heze.welcome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.http.views.StatusBarUtils;
import com.smartbus.heze.welcome.bean.Notice;
import com.smartbus.heze.welcome.module.WelcomeContract;
import com.smartbus.heze.welcome.presenter.WelcomePresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity implements WelcomeContract.View {
    private WelcomePresenter presenter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new StatusBarUtils().setWindowStatusBarColor(WelcomeActivity.this, R.color.white);
        presenter = new WelcomePresenter(this, this);
        presenter.getNoticeList();
    }

    @Override
    public void setNoticeList(Notice bean) {
        List<Notice.ResultBean> beanList = new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            beanList.add(bean.getResult().get(i));
        }
        EventBus.getDefault().postSticky(beanList);
        intent = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    //获取错误信息
    @Override
    public void setNoticeMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        intent = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
    }
}
