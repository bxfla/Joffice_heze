package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.RewardPenalties;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface RewardPenaltiesContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setRewardPenalties(RewardPenalties s);
        void setRewardPenaltiesMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getRewardPenalties(String startTime, String endTime);
    }
}
