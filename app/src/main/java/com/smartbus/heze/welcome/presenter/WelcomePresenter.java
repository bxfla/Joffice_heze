package com.smartbus.heze.welcome.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.welcome.bean.Notice;
import com.smartbus.heze.welcome.module.WelcomeContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class WelcomePresenter implements WelcomeContract.presenter {

    private Context context;
    private WelcomeContract.View view;

    public WelcomePresenter(Context context, WelcomeContract.View view) {
        this.context = context;
        this.view = view;
    }

    /**
     * 获取车站列表
     */
    @Override
    public void getNoticeList() {
        RetrofitUtil.getInstance().initRetrofitMain().getNoticeList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<Notice>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(Notice t) throws Exception {
                        view.setNoticeList(t);
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setNoticeMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
