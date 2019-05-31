package com.smartbus.heze.other.module;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface SaferUpContract {
    interface View extends BaseDSecondView<presenter> {
        void setSaferUp(UpData upData);
        void setSaferUpMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void getSaferUp(String userName, String apPlace,String apType,String apDate
                , String apReason,String apPhoto);
    }
}
