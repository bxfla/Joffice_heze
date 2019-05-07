package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.WorkPerson;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface WorkPersonContract {
    interface View extends BaseDView<presenter> {
        //获取部门
        void setWorkPerson(WorkPerson workPerson);
        void setWorkPersonMessage(String s);
    }

    interface presenter extends BasePresenter {
        //部门回调
        void getWorkPerson();
    }
}
