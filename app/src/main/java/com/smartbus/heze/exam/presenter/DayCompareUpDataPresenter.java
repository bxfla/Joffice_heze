package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.exam.module.DayCompareUpDataContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class DayCompareUpDataPresenter implements DayCompareUpDataContract.presenter {

    private Context context;
    private DayCompareUpDataContract.View view;

    public DayCompareUpDataPresenter(Context context, DayCompareUpDataContract.View view) {
        this.context = context;
        this.view = view;
    }


    @Override
    public void getUpData(String data, String scoreData, String kaoheDate, String lineCode, String carNo
            , String busCode, String depId, String depName, String driVerName, String driverId
            , String examiner, String note,String categoryCode) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getUpDayCamoareData(data,scoreData,kaoheDate,lineCode,carNo
                ,busCode,depId,depName,driVerName,driverId,examiner,note,categoryCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UpData>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(UpData s) throws Exception {
                        view.setUpData(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setUpDataMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
