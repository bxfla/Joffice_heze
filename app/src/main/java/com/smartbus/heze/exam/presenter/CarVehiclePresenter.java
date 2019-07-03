package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.CarVehicle;
import com.smartbus.heze.exam.module.CarVehicleContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CarVehiclePresenter implements CarVehicleContract.presenter {

    private Context context;
    private CarVehicleContract.View view;

    public CarVehiclePresenter(Context context, CarVehicleContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCarVehicle(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getcarvehicle(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CarVehicle>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CarVehicle s) throws Exception {
                        view.setCarVehicle(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCarVehicleMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
