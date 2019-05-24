package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.HealthHistoryItem;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface HealthHistoryItemContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setHealthHistoryItem(HealthHistoryItem s);
        void setHealthHistoryItemMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getHealthHistoryItem(String id);
    }
}
