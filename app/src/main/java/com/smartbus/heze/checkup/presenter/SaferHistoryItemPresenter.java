package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.CarCheckHistoryItem;
import com.smartbus.heze.checkup.module.SaferHistoryItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class SaferHistoryItemPresenter implements SaferHistoryItemContract.presenter {

    private Context context;
    private SaferHistoryItemContract.View view;

    public SaferHistoryItemPresenter(Context context, SaferHistoryItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getSaferHistoryItem(String id) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getSaferHistoryItem(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CarCheckHistoryItem>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CarCheckHistoryItem s) throws Exception {
                        view.setSaferHistoryItem(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setSaferHistoryItemMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
