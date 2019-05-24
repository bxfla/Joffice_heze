package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.HealthHistoryItem;
import com.smartbus.heze.checkup.module.HealthHistoryItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class HealthHistoryItemPresenter implements HealthHistoryItemContract.presenter {

    private Context context;
    private HealthHistoryItemContract.View view;

    public HealthHistoryItemPresenter(Context context, HealthHistoryItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getHealthHistoryItem(String id) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getHealthHistoryItem(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<HealthHistoryItem>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(HealthHistoryItem s) throws Exception {
                        view.setHealthHistoryItem(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setHealthHistoryItemMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
