package com.smartbus.heze.exam.module;

import com.smartbus.heze.exam.bean.Score;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface ScoreContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setScore(Score s);
        void setScoreMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getScore(String userName);
    }
}
