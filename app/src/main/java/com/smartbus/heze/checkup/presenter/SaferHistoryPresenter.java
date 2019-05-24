package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.SaferHistory;
import com.smartbus.heze.checkup.module.SaferHistoryContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class SaferHistoryPresenter implements SaferHistoryContract.presenter {

    private Context context;
    private SaferHistoryContract.View view;

    public SaferHistoryPresenter(Context context, SaferHistoryContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getSaferHistory(String startTime, String endTime, String carNo) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getSaferHistory(startTime,endTime,carNo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<SaferHistory>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(SaferHistory s) throws Exception {
                        view.setSaferHistory(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setSaferHistoryMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
