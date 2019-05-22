package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.HealthItem;
import com.smartbus.heze.checkup.module.HealthItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class HealthItemPresenter implements HealthItemContract.presenter {

    private Context context;
    private HealthItemContract.View view;

    public HealthItemPresenter(Context context, HealthItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getHealthItem() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getHealthItem().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<HealthItem>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(HealthItem s) throws Exception {
                        view.setHealthItem(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setHealthItemMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
