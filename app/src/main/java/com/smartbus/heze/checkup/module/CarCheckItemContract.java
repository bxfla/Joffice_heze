package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.CarCheckItem;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CarCheckItemContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setCarCheckItem(CarCheckItem s);
        void setCarCheckItemMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCarCheckItem(String categoryCode,String tag);
    }
}
