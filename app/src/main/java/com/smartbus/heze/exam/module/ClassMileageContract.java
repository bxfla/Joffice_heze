package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.ClassMileage;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface ClassMileageContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setClassMileage(ClassMileage s);
        void setClassMileageMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getClassMileage(String startTime, String endTime);
    }
}
