package com.smartbus.heze.oaflow.module;

import com.smartbus.heze.fileapprove.bean.InitBackData;
import com.smartbus.heze.http.base.BaseDFourView;
import com.smartbus.heze.http.base.BasePresenter;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface AtWorkContract {
    interface View extends BaseDFourView<presenter> {
        //预算单
        void setAtWork(InitBackData s);
        void setAtWorkMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getAtWork(Map<String, String> map);
    }
}
