package com.smartbus.heze.oasheet.module;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseDSecondView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface UpOaDetailContract {
    interface View extends BaseDSecondView<presenter> {
        //预算单
        void setUpOaDetail(UpData s);
        void setUpOaDetailMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getUpOaDetail(String flag, String status, String clResult, String clPhoto, String workId, String shStatus, String shResult);
    }
}
