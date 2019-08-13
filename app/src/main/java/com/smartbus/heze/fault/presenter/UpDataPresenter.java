package com.smartbus.heze.fault.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.fault.module.UpDataContract;
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
    public void getUpData(String no,String atAtDate, String atTime, String busCode,String carNo, String lineCode, String weather
                    ,String acPlaceCategory, String atType, String atLiability,String acNature, String atCategory, String userCode
                    ,String injuredPeople, String deathPeople, String atPlace,String atReason, String depId, String depName
                    ,String atPhoto, String mileType,String jbr,String money,String reason) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getUpData(no,atAtDate,atTime,busCode,carNo,lineCode,weather
                    ,acPlaceCategory,atType,atLiability,acNature,atCategory,userCode,injuredPeople,deathPeople,atPlace
                    ,atReason,depId,depName,atPhoto,mileType,jbr,money,reason).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UpData>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(UpData s) throws Exception {
                        view.setUpData(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setUpData("失败了----->" + e.getMessage());
                    }
                });
    }
}
