package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.WillDoUp;
import com.smartbus.heze.http.base.BaseDFiveView;
import com.smartbus.heze.http.base.BasePresenter;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface WillDoContract {
    interface View extends BaseDFiveView<presenter> {
        //获取部门
        void setWillDo(WillDoUp s);
        void setWillDoMessage(String s);
    }

    interface presenter extends BasePresenter {
        //部门回调
        void getWillDo(Map<String,String> map);
    }
}
