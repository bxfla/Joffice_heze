package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.CurrencyAccidentWill;
import com.smartbus.heze.fileapprove.module.CurrencyAccidentWillContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CurrencyAccidentWillPresenter implements CurrencyAccidentWillContract.presenter {

    private Context context;
    private CurrencyAccidentWillContract.View view;

    public CurrencyAccidentWillPresenter(Context context, CurrencyAccidentWillContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCurrencyAccidentWill(String activityName, String taskId, String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillCurrencyAccident(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CurrencyAccidentWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CurrencyAccidentWill s) throws Exception {
                        view.setCurrencyAccidentWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCurrencyAccidentWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
