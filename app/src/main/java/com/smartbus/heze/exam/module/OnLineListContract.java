package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.OnLineList;
import com.smartbus.heze.http.base.BaseDThirdView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface OnLineListContract {
    interface View extends BaseDThirdView<presenter> {
        //预算单
        void setOnLineList(OnLineList s);
        void setOnLineListMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getOnLineList(String examType,String startType,String userName);
    }
}
