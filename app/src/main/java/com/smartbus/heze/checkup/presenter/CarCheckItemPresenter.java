package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.CarCheckItem;
import com.smartbus.heze.checkup.module.CarCheckItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CarCheckItemPresenter implements CarCheckItemContract.presenter {

    private Context context;
    private CarCheckItemContract.View view;

    public CarCheckItemPresenter(Context context, CarCheckItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCarCheckItem(String categoryCode,String tag) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getCarCheckItem(categoryCode,tag).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CarCheckItem>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CarCheckItem s) throws Exception {
                        view.setCarCheckItem(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCarCheckItemMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
