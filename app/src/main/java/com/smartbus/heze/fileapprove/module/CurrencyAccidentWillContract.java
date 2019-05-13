package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.CurrencyAccidentWill;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CurrencyAccidentWillContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setCurrencyAccidentWill(CurrencyAccidentWill s);
        void setCurrencyAccidentWillMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCurrencyAccidentWill(String activityName, String taskId, String defId);
    }
}
