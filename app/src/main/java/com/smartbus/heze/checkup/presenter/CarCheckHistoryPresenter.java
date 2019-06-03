package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.CarCheckHistory;
import com.smartbus.heze.checkup.module.CarCehckHistoryContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CarCheckHistoryPresenter implements CarCehckHistoryContract.presenter {

    private Context context;
    private CarCehckHistoryContract.View view;

    public CarCheckHistoryPresenter(Context context, CarCehckHistoryContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCarCehckHistory(String startTime, String endTime, String carNo) {
        try {
            RetrofitUtil.getInstance().initRetrofitSetSession().getCarCheckHistory(startTime,endTime, URLEncoder.encode(carNo, "UTF-8")).subscribeOn(Schedulers.io())
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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
