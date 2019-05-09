package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.HuiQianWill;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface HuiQianWillContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setBorrowAccidentWill(HuiQianWill s);
        void setBorrowAccidentWillMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getBorrowAccidentWill(String activityName,String taskId,String defId);
    }
}
