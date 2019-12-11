package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.DJDepartment;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface DJDepartmentContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setDJDepartment(DJDepartment s);
        void setDJDepartmentMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getDJDepartment(String depType, String demId);
    }
}
