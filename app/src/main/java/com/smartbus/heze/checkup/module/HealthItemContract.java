package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.HealthItem;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface HealthItemContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setHealthItem(HealthItem s);
        void setHealthItemMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getHealthItem();
    }
}
