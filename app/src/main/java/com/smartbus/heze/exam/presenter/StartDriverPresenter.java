package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.StartDriver;
import com.smartbus.heze.exam.module.StartDriverContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class StartDriverPresenter implements StartDriverContract.presenter {

    private Context context;
    private StartDriverContract.View view;

    public StartDriverPresenter(Context context, StartDriverContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getStartDriver(String startTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getstartdriver(startTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<StartDriver>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(StartDriver s) throws Exception {
                        view.setStartDriver(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setStartDriverMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
