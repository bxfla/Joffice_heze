package com.smartbus.heze.welcome.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.welcome.bean.Login;
import com.smartbus.heze.welcome.module.LoginContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class LoginPresenter implements LoginContract.presenter {

    private Context context;
    private LoginContract.View view;

    public LoginPresenter(Context context, LoginContract.View view) {
        this.context = context;
        this.view = view;
    }

    /**
     * 登录
     *
     */

    @Override
    public void getLoginList(String username,String password) {
        RetrofitUtil.getInstance().initRetrofitMain().getLogin(username,password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<Login>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(Login t) throws Exception {
                        view.setLoginList(t);
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setLoginMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
