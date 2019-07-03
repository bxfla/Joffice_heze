package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.GPSMileage;
import com.smartbus.heze.exam.module.GpsMileageContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class GpsMileagePresenter implements GpsMileageContract.presenter {

    private Context context;
    private GpsMileageContract.View view;

    public GpsMileagePresenter(Context context, GpsMileageContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getGpsMileage(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getstartdriver(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<GPSMileage>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(GPSMileage s) throws Exception {
                        view.setGpsMileage(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setGpsMileageMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
