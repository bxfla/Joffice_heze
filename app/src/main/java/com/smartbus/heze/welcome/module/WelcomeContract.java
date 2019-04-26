package com.smartbus.heze.welcome.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.welcome.bean.Notice;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface WelcomeContract {
    interface View extends BaseDView<presenter> {
        //获取车站列表
        void setNoticeList(Notice bean);
        void setNoticeMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getNoticeList();
    }
}
