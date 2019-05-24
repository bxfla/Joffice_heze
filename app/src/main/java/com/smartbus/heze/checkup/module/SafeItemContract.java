package com.smartbus.heze.checkup.module;

import com.smartbus.heze.checkup.bean.SafeHistoryItem;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface SafeItemContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setSafeItem(SafeHistoryItem s);
        void setSafeItemMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getSafeItem();
    }
}
