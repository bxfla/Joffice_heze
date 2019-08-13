package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.CarCheckHistoryItem;
import com.smartbus.heze.exam.module.DayCompareHistoryItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class DayCompareHistoryItemPresenter implements DayCompareHistoryItemContract.presenter {

    private Context context;
    private DayCompareHistoryItemContract.View view;

    public DayCompareHistoryItemPresenter(Context context, DayCompareHistoryItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCarCehckHistoryItem(String id) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getDayCompareHistoryItem(id).subscribeOn(Schedulers.io())
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
