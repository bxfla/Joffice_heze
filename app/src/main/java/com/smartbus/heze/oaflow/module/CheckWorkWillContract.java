package com.smartbus.heze.oaflow.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.AtWorkWill;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CheckWorkWillContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setCheckWorkWill(AtWorkWill s);
        void setCheckWorkWillMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCheckWorkWill(String activityName, String taskId, String defId);
    }
}
