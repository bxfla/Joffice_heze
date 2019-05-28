package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.LearnRight;
import com.smartbus.heze.http.base.BaseDThirdView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface LearnRightContract {
    interface View extends BaseDThirdView<presenter> {
        //预算单
        void setLearnRight(LearnRight s);
        void setLearnRightMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getLearnRight(String type);
    }
}
