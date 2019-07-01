package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.OilConsumption;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface OilConsumptionContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setOilConsumption(OilConsumption s);
        void setOilConsumptionMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getOilConsumption(String startTime, String endTime);
    }
}
