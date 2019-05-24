package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.HealthHistory;
import com.smartbus.heze.checkup.module.HealthHistoryContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class HistoryHistoryPresenter implements HealthHistoryContract.presenter {

    private Context context;
    private HealthHistoryContract.View view;

    public HistoryHistoryPresenter(Context context, HealthHistoryContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getHealthHistory(String startTime, String endTime, String carNo) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getHealthHistory(startTime,endTime,carNo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<HealthHistory>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(HealthHistory s) throws Exception {
                        view.setHealthHistory(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setHealthHistoryMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
