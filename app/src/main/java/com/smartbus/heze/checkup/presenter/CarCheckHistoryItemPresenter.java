package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.CarCheckHistoryItem;
import com.smartbus.heze.checkup.module.CarCehckHistoryItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CarCheckHistoryItemPresenter implements CarCehckHistoryItemContract.presenter {

    private Context context;
    private CarCehckHistoryItemContract.View view;

    public CarCheckHistoryItemPresenter(Context context, CarCehckHistoryItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCarCehckHistoryItem(String id) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getCarCheckHistoryItem(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CarCheckHistoryItem>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CarCheckHistoryItem s) throws Exception {
                        view.setCarCehckHistoryItem(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCarCehckHistoryItemMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
