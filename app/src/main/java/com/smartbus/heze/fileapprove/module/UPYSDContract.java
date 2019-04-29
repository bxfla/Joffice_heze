package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.http.base.BaseDThirdView;
import com.smartbus.heze.http.base.BasePresenter;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface UPYSDContract {
    interface View extends BaseDThirdView<presenter> {
        //预算单
        void setUPYSD(String s);
        void setUPYSDMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getUPYSD(Map<String,String> map);
    }
}
