package com.smartbus.heze.main.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.main.bean.OaWillDo;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface OaWillListContract {
    interface View extends BaseDView<presenter> {
        //设置banner
        void setOaWillList(OaWillDo oaWillList);
        void setOaWillListMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void getOaWillList(String userName,String type,String type1,int start,int limit);
    }
}
