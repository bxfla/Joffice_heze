package com.smartbus.heze.other.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.other.module.AdverUpContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class AdverUpPresenter implements AdverUpContract.presenter {

    private Context context;
    private AdverUpContract.View view;

    public AdverUpPresenter(Context context, AdverUpContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void AdverUp(String company, String contacts, String number, String address, String memo) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getAdverUpData(company,contacts,number
                ,address,memo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UpData>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(UpData t) throws Exception {
                        view.setAdverUp(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setAdverUpMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
