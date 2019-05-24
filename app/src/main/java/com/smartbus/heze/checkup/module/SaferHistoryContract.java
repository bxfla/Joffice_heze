package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.SaferHistory;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface SaferHistoryContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setSaferHistory(SaferHistory s);
        void setSaferHistoryMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getSaferHistory(String startTime, String endTime, String carNo);
    }
}
