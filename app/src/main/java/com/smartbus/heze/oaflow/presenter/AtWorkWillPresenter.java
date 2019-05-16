package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.AtWorkWill;
import com.smartbus.heze.oaflow.module.AtWorkWillContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class AtWorkWillPresenter implements AtWorkWillContract.presenter {

    private Context context;
    private AtWorkWillContract.View view;

    public AtWorkWillPresenter(Context context, AtWorkWillContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getAtWorkWill(String activityName, String taskId, String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillAtWork(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<AtWorkWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(AtWorkWill s) throws Exception {
                        view.setAtWorkWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setAtWorkWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
