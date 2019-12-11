package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.AccidentLRData;
import com.smartbus.heze.fileapprove.module.CurrencyAccidentLRContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CurrencyAccidentLRPresenter implements CurrencyAccidentLRContract.presenter {

    private Context context;
    private CurrencyAccidentLRContract.View view;

    public CurrencyAccidentLRPresenter(Context context, CurrencyAccidentLRContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCurrencyAccidentLR(Map<String, String> map) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getCurrencyAccidentLR(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<AccidentLRData>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(AccidentLRData s) throws Exception {
                        view.setCurrencyAccidentLR(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCurrencyAccidentLRMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
