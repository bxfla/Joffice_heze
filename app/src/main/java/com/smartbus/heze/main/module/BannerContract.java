package com.smartbus.heze.main.module;

import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.main.bean.Banner;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface BannerContract {
    interface View extends BaseDView<presenter> {
        //设置banner
        void setBanner(Banner banner);
        void setBannerMessage(String s);
    }

    interface presenter extends BasePresenter {
        //banner回调
        void getBanner();
    }
}
