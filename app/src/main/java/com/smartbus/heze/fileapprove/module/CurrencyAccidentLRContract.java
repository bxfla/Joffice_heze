package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.AccidentLRData;
import com.smartbus.heze.http.base.BaseDFourView;
import com.smartbus.heze.http.base.BasePresenter;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface CurrencyAccidentLRContract {
    interface View extends BaseDFourView<presenter> {
        //通用借款录入
        void setCurrencyAccidentLR(AccidentLRData s);
        void setCurrencyAccidentLRMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getCurrencyAccidentLR(Map<String, String> map);
    }
}
