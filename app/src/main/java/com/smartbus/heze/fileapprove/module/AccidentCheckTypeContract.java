package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.http.base.BaseDSevenView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.CheckType;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface AccidentCheckTypeContract {
    interface View extends BaseDSevenView<presenter> {
        //通用借款修改状态
        void setAccidentCheckType(CheckType s);
        void setAccidentCheckTypeMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getAccidentCheckType(String runId, String vocationId);
    }
}
