package com.smartbus.heze.other.module;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseDThirdView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface UpICMSContract {
    interface View extends BaseDThirdView<presenter> {
        //设置banner
        void setUpICMS(UpData upData);
        void setUpICMSMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void getUpICMS(String userName,String driverName,String driverCode,String lineCode
                ,String cardId,String cardType,String money,String reasons,String date,String memo);
    }
}
