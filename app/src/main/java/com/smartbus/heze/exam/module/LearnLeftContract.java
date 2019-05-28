package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.LearnLeft;
import com.smartbus.heze.http.base.BaseDThirdView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface LearnLeftContract {
    interface View extends BaseDThirdView<presenter> {
        //预算单
        void setLearnLeft(LearnLeft s);
        void setLearnLeftMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getLearnLeft();
    }
}
