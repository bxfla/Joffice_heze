package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.http.base.BaseDSixView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.CheckType;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface BorrowAccidentWillCheckTypeContract {
    interface View extends BaseDSixView<presenter> {
        //事故借款修改状态
        void setBorrowAccidentWillCheckType(CheckType s);
        void setBorrowAccidentWillCheckTypeMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getBorrowAccidentWillCheckType(String runId, String vocationId, String destName, String mycomments);
    }
}
