package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.LineCode;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface LineCodeContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setLineCode(LineCode s);
        void setLineCodeMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getLineCode();
    }
}
