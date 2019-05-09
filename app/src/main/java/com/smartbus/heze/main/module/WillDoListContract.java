package com.smartbus.heze.main.module;

import com.smartbus.heze.http.base.BaseDFiveView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.main.bean.WillDoList;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface WillDoListContract {
    interface View extends BaseDFiveView<presenter> {
        //设置banner
        void setWillDoList(WillDoList willDoList);
        void setWillDoListMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void getWillDoList();
    }
}
