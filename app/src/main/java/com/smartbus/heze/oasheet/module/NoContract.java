package com.smartbus.heze.oasheet.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oasheet.bean.OANO;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface NoContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setNo(OANO s);
        void setNoMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getNo(String alias);
    }
}
