package com.smartbus.heze.welcome.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.welcome.bean.Login;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface LoginContract {
    interface View extends BaseDView<presenter> {
        //获取车站列表
        void setLoginList(Login bean);
        void setLoginMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getLoginList(String username,String password,String versionName);
    }
}
