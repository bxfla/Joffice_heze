package com.smartbus.heze.oaflow.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.AddWorkWill;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface AddWorkWillContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setAddWorkWill(AddWorkWill s);
        void setAddWorkWillMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getAddWorkWill(String activityName, String taskId, String defId);
    }
}
