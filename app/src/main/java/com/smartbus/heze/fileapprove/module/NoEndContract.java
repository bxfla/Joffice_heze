package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.NoEndPerson;
import com.smartbus.heze.http.base.BaseDThirdView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface NoEndContract {
    interface View extends BaseDThirdView<presenter> {
        //预算单
        void setNoEndPerson(NoEndPerson s);
        void setNoEndPersonMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getNoEndPerson(String taskId, String activityName, String isParentFlow);
    }
}
