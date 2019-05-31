package com.smartbus.heze.other.module;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface LostUpContract {
    interface View extends BaseDSecondView<presenter> {
        void setLostUp(UpData upData);
        void setLostUpMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void getLostUp(String userName, String createDate, String createTime, String lineCode
                , String driverName,String receiveDate, String receiveTime, String ownerName
                , String ownerPhone, String returnMode,String ownerCertificates, String returnStatus
                , String situation, String remarks, String photo);
    }
}
