package com.smartbus.heze.oasheet.module;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface UpOaContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setUpOa(UpData s);
        void setUpOaMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getUpOa(String flag,String no,String overDepName,String overDepId,String sendDepName
                ,String sendDepId,String sendPerson,String upDate,String upTime,String endTime,String title
                ,String type,String content,String fileName);
    }
}
