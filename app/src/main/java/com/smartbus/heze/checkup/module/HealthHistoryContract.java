package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.HealthHistory;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface HealthHistoryContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setHealthHistory(HealthHistory s);
        void setHealthHistoryMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getHealthHistory(String startTime, String endTime, String carNo);
    }
}
