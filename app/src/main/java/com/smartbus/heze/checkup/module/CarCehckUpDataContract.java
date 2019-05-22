package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CarCehckUpDataContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setUpData(UpData s);
        void setUpDataMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getUpData(String data, String scoreData, String kaoheDate, String lineCode, String carNo, String busCode
                , String depId, String depName, String driVerName, String driverId, String examiner, String note,String categoryCode);
    }
}
