package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.OnLineUp;
import com.smartbus.heze.http.base.BaseDFourView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface OnLineUpContract {
    interface View extends BaseDFourView<presenter> {
        //预算单
        void setOnLineUp(OnLineUp s);
        void setOnLineUpMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getOnLineUp(String userName, String type, String answer);
    }
}
