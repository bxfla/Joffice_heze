package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.ExaminationData;
import com.smartbus.heze.http.base.BaseDThirdView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface ExamationDataContract {
    interface View extends BaseDThirdView<presenter> {
        //预算单
        void setExamationData(ExaminationData s);
        void setExamationDataMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getExamationData(String id, String type, String userName);
    }
}
