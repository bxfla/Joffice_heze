package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.AtWorkWill;
import com.smartbus.heze.oaflow.module.CheckWorkWillContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CheckWorkWillPresenter implements CheckWorkWillContract.presenter {

    private Context context;
    private CheckWorkWillContract.View view;

    public CheckWorkWillPresenter(Context context, CheckWorkWillContract.View view) {
        this.context = context;
        this.view = view;
    }


    @Override
    public void getCheckWorkWill(String activityName, String taskId, String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillAtWork(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<AtWorkWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(AtWorkWill s) throws Exception {
                        view.setCheckWorkWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCheckWorkWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
