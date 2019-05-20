package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.CheckPerson;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CheckPersonContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setCheckPerson(CheckPerson s);
        void setCheckPersonMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCheckPerson();
    }
}
