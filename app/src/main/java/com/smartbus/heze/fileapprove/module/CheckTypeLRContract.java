package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.http.base.BaseDSixView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.CheckType;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CheckTypeLRContract {
    interface View extends BaseDSixView<presenter> {
        //预算单
        void setCheckTypeLR(CheckType s);
        void setCheckTypeLRMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCheckTypeLR(String vocationId);
    }
}
