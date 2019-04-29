package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.Department;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface DepartmentContract {
    interface View extends BaseDView<presenter> {
        //获取部门
        void setDepartment(Department department);
        void setDepartmentMessage(String s);
    }

    interface presenter extends BasePresenter {
        //部门回调
        void getDepartment();
    }
}
