package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.SafeMileage;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface SafeMileageContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setSafeMileage(SafeMileage s);
        void setSafeMileageMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getSafeMileage(String startTime, String endTime);
    }
}
