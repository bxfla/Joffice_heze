package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.GPSMileage;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface GpsMileageContract {
    interface View extends BaseDView<presenter> {
        void setGpsMileage(GPSMileage s);
        void setGpsMileageMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getGpsMileage(String startTime, String endTime);
    }
}
