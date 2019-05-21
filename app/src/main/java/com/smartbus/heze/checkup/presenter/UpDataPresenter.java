package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.checkup.module.UpDataContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class UpDataPresenter implements UpDataContract.presenter {

    private Context context;
    private UpDataContract.View view;

    public UpDataPresenter(Context context, UpDataContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getUpData(String data,String scoreData,String kaoheDate, String lineCode, String carNo, String busCode
            , String depId, String depName, String driVerName, String driverId, String examiner, String note
            , String type, String time) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getUpData(data,scoreData,kaoheDate,lineCode,carNo
                                    ,busCode,depId,depName,driVerName,driverId,examiner,note,type,time)
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
