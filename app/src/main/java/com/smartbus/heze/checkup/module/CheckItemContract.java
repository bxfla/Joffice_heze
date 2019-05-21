package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.CheckItem;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CheckItemContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setCheckItem(CheckItem s);
        void setCheckItemMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCheckItem();
    }
}
