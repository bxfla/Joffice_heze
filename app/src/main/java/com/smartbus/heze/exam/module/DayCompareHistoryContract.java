package com.smartbus.heze.exam.module;

import com.smartbus.heze.checkup.bean.CarCheckHistory;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface DayCompareHistoryContract {
    interface View extends BaseDSecondView<presenter> {
        void setCarCehckHistory(CarCheckHistory s);
        void setCarCehckHistoryMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCarCehckHistory(String startTime, String endTime, String carNo);
    }
}
