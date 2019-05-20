package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.CarCode;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CarCodeContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setCarCode(CarCode s);
        void setCarCodeMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCarCode();
    }
}
