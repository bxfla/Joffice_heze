package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.WorkOnePerson;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface WorkOnePersonContract {
    interface View extends BaseDView<presenter> {
        //获取部门
        void setWorkOnePerson(WorkOnePerson workPerson);
        void setWorkOnePersonMessage(String s);
    }

    interface presenter extends BasePresenter {
        //部门回调
        void getWorkOnePerson();
    }
}
