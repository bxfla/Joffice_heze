package com.smartbus.heze.welcome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.http.base.AlertDialogCallBack;
import com.smartbus.heze.http.base.AlertDialogUtil;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.main.activity.MainActivity;
import com.smartbus.heze.welcome.bean.Login;
import com.smartbus.heze.welcome.module.LoginContract;
import com.smartbus.heze.welcome.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.et_LoginName)
    EditText etLoginName;
    @BindView(R.id.et_LoginPassword)
    EditText etLoginPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    Intent intent;
    String username = "";
    String password = "";
    LoginPresenter loginPresenter;
    SharedPreferencesHelper sharedPreferencesHelper;

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
        //密码隐藏
        etLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        sharedPreferencesHelper = new SharedPreferencesHelper(this,"login");
        username = sharedPreferencesHelper.getData(this, "userName", "");
        password = sharedPreferencesHelper.getData(this, "userPwd", "");
        if (!username.isEmpty()) {
            etLoginName.setText(username);
        }
        if (!password.isEmpty()) {
            etLoginPassword.setText(password);
        }
        loginPresenter = new LoginPresenter(this,this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
    }

    @OnClick({R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                username = etLoginName.getText().toString();
                password = etLoginPassword.getText().toString();
                if (username!=null&&password!=null&&!username.equals("")&&!password.equals("")){
                    loginPresenter.getLoginList(username,password);
                }else {
                    Toast.makeText(this, "请输入用户名密码", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void setLoginList(Login bean) {
        sharedPreferencesHelper.saveData(LoginActivity.this, "userName", username);
        sharedPreferencesHelper.saveData(LoginActivity.this, "userPwd", password);
        sharedPreferencesHelper.saveData(LoginActivity.this, "userName1", bean.getUsername());
        sharedPreferencesHelper.saveData(LoginActivity.this, "userId", bean.getUserId());
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void setLoginMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
