package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.StartContent;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface StartContentContract {
    interface View extends BaseDView<presenter> {
        void setStartContent(StartContent s);
        void setStartContentMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getStartContent(String startTime, String endTime);
    }
}
