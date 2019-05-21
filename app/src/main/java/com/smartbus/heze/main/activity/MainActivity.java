package com.smartbus.heze.main.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.smartbus.heze.R;
import com.smartbus.heze.http.base.AlertDialogCallBack;
import com.smartbus.heze.http.base.AlertDialogUtil;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.main.fragment.Fragment01;
import com.smartbus.heze.main.fragment.Fragment02;
import com.smartbus.heze.main.fragment.Fragment03;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private FragmentManager manager;

    AlertDialogUtil alertDialogUtil;
    private static boolean isExit = false;

    //推出程序
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    //推出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            alertDialogUtil.showDialog("您确定要退出程序吗", new AlertDialogCallBack() {

                @Override
                public int getData(int s) {
                    return 0;
                }

                @Override
                public void confirm() {
                    finish();
                }

                @Override
                public void cancel() {

                }
            });
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        //默认选中第一个
        RadioButton btn = (RadioButton) radioGroup.getChildAt(0);
        btn.setChecked(true);
        initFragment();
        radioGroup.setOnCheckedChangeListener(MainActivity.this);
    }
    /**
     * 初始化第一个页面
     */
    private void initFragment() {
        //获取管理器
        manager = getSupportFragmentManager();
        //通过管理器获取一个事件
        FragmentTransaction transaction = manager.beginTransaction();
        //添加第一个fragment到帧布局中
        fragment01 = new Fragment01();
        transaction.add(R.id.frame_layout, fragment01);
        transaction.commit();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            //线路查询
            case R.id.rb1:
                FragmentTransaction ft1 = manager.beginTransaction();
                hideAll(ft1);
                if (fragment01 ==null){
                    fragment01 = new Fragment01();
                    ft1.add(R.id.frame_layout, fragment01);
                }else {
                    ft1.show(fragment01);
                }
                ft1.commit();
                break;
            //公交换乘
            case R.id.rb2://联系人
                FragmentTransaction ft2 = manager.beginTransaction();
                hideAll(ft2);
                if (fragment02 ==null){
                    fragment02 = new Fragment02();
                    ft2.add(R.id.frame_layout, fragment02);
                }else {
                    ft2.show(fragment02);
                }
                ft2.commit();
                break;
            //站点查询
            case R.id.rb3: //发现
                FragmentTransaction ft3 = manager.beginTransaction();
                hideAll(ft3);
                if (fragment03 ==null){
                    fragment03 = new Fragment03();
                    ft3.add(R.id.frame_layout, fragment03);
                }else {
                    ft3.show(fragment03);
                }
                ft3.commit();
                break;
        }
    }

    /**
     * 隐藏所有fragment
     * @param ft
     */
    private void hideAll(FragmentTransaction ft){
        if (ft==null){
            return;
        }
        if (fragment01 !=null){
            ft.hide(fragment01);
        }
        if (fragment02 !=null){
            ft.hide(fragment02);
        }
        if (fragment03 !=null){
            ft.hide(fragment03);
        }
    }
}
