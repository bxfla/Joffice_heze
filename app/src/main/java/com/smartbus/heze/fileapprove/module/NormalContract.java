package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.NormalPerson;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface NormalContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setNormalPerson(NormalPerson s);
        void setNormalPersonMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getNormalPerson(String taskId,String activityName,String isParentFlow);
    }
}
