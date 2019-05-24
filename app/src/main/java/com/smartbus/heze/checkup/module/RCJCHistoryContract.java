package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.RCJCHistory;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface RCJCHistoryContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setRCJCHistory(RCJCHistory s);
        void setRCJCHistoryMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getRCJCHistory(String startTime, String endTime, String carNo);
    }
}
