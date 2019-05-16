package com.smartbus.heze.oaflow.module;

import com.smartbus.heze.http.base.BaseDSixView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.CheckType;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface OldCheckTypeContract {
    interface View extends BaseDSixView<presenter> {
        //预算单
        void setCheckType(CheckType s);
        void setCheckTypeMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCheckType(String runId, String vocationId);
    }
}
