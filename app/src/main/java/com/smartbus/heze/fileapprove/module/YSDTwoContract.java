package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface YSDTwoContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setYSDTwo(TwoPerson s);
        void setYSDTwoMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getYSDTwo(String defId,String activityName);
    }
}
