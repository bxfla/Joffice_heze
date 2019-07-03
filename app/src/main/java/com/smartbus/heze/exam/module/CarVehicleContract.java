package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.CarVehicle;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CarVehicleContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setCarVehicle(CarVehicle s);
        void setCarVehicleMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCarVehicle(String startTime, String endTime);
    }
}
