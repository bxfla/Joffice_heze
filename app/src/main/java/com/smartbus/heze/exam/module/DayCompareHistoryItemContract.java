package com.smartbus.heze.exam.module;

import com.smartbus.heze.checkup.bean.CarCheckHistoryItem;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface DayCompareHistoryItemContract {
    interface View extends BaseDSecondView<presenter> {
        void setCarCehckHistoryItem(CarCheckHistoryItem s);
        void setCarCehckHistoryItemMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCarCehckHistoryItem(String id);
    }
}
