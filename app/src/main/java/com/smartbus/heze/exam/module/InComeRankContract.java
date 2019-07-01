package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.InComeRank;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface InComeRankContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setInComeRank(InComeRank s);
        void setInComeRankMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getInComeRank(String startTime,String endTime);
    }
}
