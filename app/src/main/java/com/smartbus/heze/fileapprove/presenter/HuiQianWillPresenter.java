package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.HuiQianWill;
import com.smartbus.heze.fileapprove.module.HuiQianWillContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class HuiQianWillPresenter implements HuiQianWillContract.presenter {

    private Context context;
    private HuiQianWillContract.View view;

    public HuiQianWillPresenter(Context context, HuiQianWillContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getBorrowAccidentWill(String activityName, String taskId,String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillDoDetail(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<HuiQianWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(HuiQianWill s) throws Exception {
                        view.setBorrowAccidentWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setBorrowAccidentWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
