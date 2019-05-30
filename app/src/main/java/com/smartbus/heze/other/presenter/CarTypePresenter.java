package com.smartbus.heze.other.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.other.bean.CarType;
import com.smartbus.heze.other.module.CarTypeContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class CarTypePresenter implements CarTypeContract.presenter {

    private Context context;
    private CarTypeContract.View view;

    public CarTypePresenter(Context context, CarTypeContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCarType() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getCarType().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CarType>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CarType t) throws Exception {
                        view.setCarType(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCarTypeMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
