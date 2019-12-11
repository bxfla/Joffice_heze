package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.CarCheckHistory;
import com.smartbus.heze.exam.module.DayCompareHistoryContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class DayCompareHistoryPresenter implements DayCompareHistoryContract.presenter {

    private Context context;
    private DayCompareHistoryContract.View view;

    public DayCompareHistoryPresenter(Context context, DayCompareHistoryContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCarCehckHistory(String startTime, String endTime, String carNo,String depId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getDayCompareHistory(startTime,endTime,carNo,depId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CarCheckHistory>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CarCheckHistory s) throws Exception {
                        view.setCarCehckHistory(s);
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCarCehckHistoryMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
