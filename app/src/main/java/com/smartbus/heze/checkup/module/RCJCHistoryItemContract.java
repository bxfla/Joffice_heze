package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.RCJCHistoryItem;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface RCJCHistoryItemContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setRCJCHistoryItem(RCJCHistoryItem s);
        void setRCJCHistoryItemMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getRCJCHistoryItem(String id);
    }
}
