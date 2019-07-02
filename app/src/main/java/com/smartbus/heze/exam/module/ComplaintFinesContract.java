package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.ComplaintFines;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface ComplaintFinesContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setComplaintFines(ComplaintFines s);
        void setComplaintFinesMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getComplaintFines(String startTime, String endTime);
    }
}
