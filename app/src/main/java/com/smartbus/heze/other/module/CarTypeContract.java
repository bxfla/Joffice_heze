package com.smartbus.heze.other.module;

import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.other.bean.CarType;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CarTypeContract {
    interface View extends BaseDSecondView<presenter> {
        //设置banner
        void setCarType(CarType carType);
        void setCarTypeMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void getCarType();
    }
}
