package com.smartbus.heze.welcome.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.welcome.bean.Version;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface VersionContract {
    interface View extends BaseDView<presenter> {
        //获取版本号
        void setVersion(Version bean);
        void setVersionMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getVersion();
    }
}
