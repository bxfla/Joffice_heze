package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.CarCheckHistoryItem;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface SaferHistoryItemContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setSaferHistoryItem(CarCheckHistoryItem s);
        void setSaferHistoryItemMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getSaferHistoryItem(String id);
    }
}
