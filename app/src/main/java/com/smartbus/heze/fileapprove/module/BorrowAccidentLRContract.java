package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.BorrowAccidentLRData;
import com.smartbus.heze.http.base.BaseDFourView;
import com.smartbus.heze.http.base.BasePresenter;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface BorrowAccidentLRContract {
    interface View extends BaseDFourView<presenter> {
        //通用借款录入
        void setBorrowAccidentLR(BorrowAccidentLRData s);
        void setBorrowAccidentLRMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getBorrowAccidentLR(Map<String, String> map);
    }
}
