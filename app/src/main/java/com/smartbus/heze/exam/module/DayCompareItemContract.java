package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.DayCompare;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface DayCompareItemContract {
    interface View extends BaseDView<presenter> {
        void setDayCompareItem(DayCompare s);
        void setDayCompareItemMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getDayCompareItem(String categoryCode, String tag);
    }
}
