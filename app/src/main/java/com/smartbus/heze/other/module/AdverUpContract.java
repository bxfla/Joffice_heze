package com.smartbus.heze.other.module;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface AdverUpContract {
    interface View extends BaseDSecondView<presenter> {
        void setAdverUp(UpData upData);
        void setAdverUpMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void AdverUp(String company, String contacts, String number, String address, String memo);
    }
}
