package com.smartbus.heze.fault.module;

import com.smartbus.heze.fault.bean.AboutData;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface AboutDataContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setAboutData(AboutData s);
        void setAboutData(String s);
    }

    interface presenter extends BasePresenter {
        void getAboutData(String busCode, String rq, String sj);
    }
}
