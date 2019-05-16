package com.smartbus.heze.oaflow.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.UserdLeaveWill;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface UserdLeaveWillContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setUserdLeaveWill(UserdLeaveWill s);
        void setUserdLeaveWillMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getUserdLeaveWill(String activityName, String taskId, String defId);
    }
}
