package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.DepartBudgetWill;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface DepartBudgetWillContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setDepartBudgetWill(DepartBudgetWill s);
        void setDepartBudgetWillMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getDepartBudgetWill(String activityName, String taskId, String defId);
    }
}
