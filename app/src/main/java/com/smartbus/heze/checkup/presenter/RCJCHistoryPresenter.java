package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.RCJCHistory;
import com.smartbus.heze.checkup.module.RCJCHistoryContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class RCJCHistoryPresenter implements RCJCHistoryContract.presenter {

    private Context context;
    private RCJCHistoryContract.View view;

    public RCJCHistoryPresenter(Context context, RCJCHistoryContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getRCJCHistory(String startTime, String endTime, String carNo) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getRCJCHistory(startTime,endTime,carNo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<RCJCHistory>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(RCJCHistory s) throws Exception {
                        view.setRCJCHistory(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setRCJCHistoryMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
