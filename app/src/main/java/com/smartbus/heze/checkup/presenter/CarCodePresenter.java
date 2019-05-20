package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.CarCode;
import com.smartbus.heze.checkup.module.CarCodeContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CarCodePresenter implements CarCodeContract.presenter {

    private Context context;
    private CarCodeContract.View view;

    public CarCodePresenter(Context context, CarCodeContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCarCode() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getCarCode().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CarCode>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CarCode s) throws Exception {
                        view.setCarCode(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCarCodeMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
