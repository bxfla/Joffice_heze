package com.smartbus.heze.fault.module;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseDThirdView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface UpDataContract {
    interface View extends BaseDThirdView<presenter> {
        //预算单
        void setUpData(UpData s);
        void setUpData(String s);
    }

    interface presenter extends BasePresenter {
        void getUpData(String no,String atAtDate, String atTime, String busCode,String carNo, String lineCode, String weather
                ,String acPlaceCategory, String atType, String atLiability,String acNature, String atCategory, String userCode
                ,String injuredPeople, String deathPeople, String atPlace,String atReason, String depId, String depName
                ,String atPhoto, String mileType);
    }
}
