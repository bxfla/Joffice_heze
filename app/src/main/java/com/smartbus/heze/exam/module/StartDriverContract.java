package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.StartDriver;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface StartDriverContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setStartDriver(StartDriver s);
        void setStartDriverMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getStartDriver(String startTime);
    }
}
