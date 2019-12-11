package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.http.base.BaseDSixView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.CheckType;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface AccidentWillCheckTypeContract {
    interface View extends BaseDSixView<presenter> {
        //通用借款修改状态
        void setAccidentWillCheckType(CheckType s);
        void setAccidentWillCheckTypeMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getAccidentWillCheckType(String runId, String vocationId, String destName, String mycomments);
    }
}
