package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.NoHandlerPerson;
import com.smartbus.heze.http.base.BaseDFourView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface NoHandlerContract {
    interface View extends BaseDFourView<presenter> {
        //预算单
        void setNoHandlerPerson(NoHandlerPerson s);
        void setNoHandlerPersonMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getNoHandlerPerson(String defId);
    }
}
