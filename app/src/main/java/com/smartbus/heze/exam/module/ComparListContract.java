package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.ComparList;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface ComparListContract {
    interface View extends BaseDSecondView<presenter> {
        void setComparList(ComparList s);
        void setComparListMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getComparList(String startTime, String endTime, String carNo, String depId);
    }
}
