package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.OilConsumption;
import com.smartbus.heze.exam.module.OilConsumptionContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class OilConsunptionPresenter implements OilConsumptionContract.presenter {

    private Context context;
    private OilConsumptionContract.View view;

    public OilConsunptionPresenter(Context context, OilConsumptionContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getOilConsumption(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getoilconsumption(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<OilConsumption>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(OilConsumption s) throws Exception {
                        view.setOilConsumption(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setOilConsumptionMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
