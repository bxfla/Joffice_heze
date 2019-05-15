package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.InitBackData;
import com.smartbus.heze.http.base.BaseDFourView;
import com.smartbus.heze.http.base.BasePresenter;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface UserdLeaveContract {
    interface View extends BaseDFourView<presenter> {
        //预算单
        void setUserdLeave(InitBackData s);
        void setUserdLeaveMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getUserdLeave(Map<String,String> map);
    }
}
