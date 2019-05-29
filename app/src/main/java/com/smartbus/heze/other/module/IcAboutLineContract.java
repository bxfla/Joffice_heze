package com.smartbus.heze.other.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.other.bean.IcAboutLine;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface IcAboutLineContract {
    interface View extends BaseDView<presenter> {
        //设置banner
        void setIcAboutLine(IcAboutLine icAboutLine);
        void setIcAboutLineMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void getIcAboutLine(String driverCode);
    }
}
