package com.smartbus.heze.oaflow.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.OldWorkWill;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface OldWorkWillContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setOldWorkWill(OldWorkWill s);
        void setOldWorkWillMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getOldWorkWill(String activityName, String taskId, String defId);
    }
}
