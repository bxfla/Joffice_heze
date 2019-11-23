package com.smartbus.heze.oaflow.module;

import com.smartbus.heze.http.base.BaseDSixView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.JianZhi;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface JianZhiContract {
    interface View extends BaseDSixView<presenter> {
        //预算单
        void setJianZhi(JianZhi s);
        void setJianZhiMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getJianZhi(String name,String userCode, String adress, String phone, String comp,String depId, String line, String beizhu);
    }
}
