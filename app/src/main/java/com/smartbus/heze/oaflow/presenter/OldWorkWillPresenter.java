package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.OldWorkWill;
import com.smartbus.heze.oaflow.module.OldWorkWillContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class OldWorkWillPresenter implements OldWorkWillContract.presenter {

    private Context context;
    private OldWorkWillContract.View view;

    public OldWorkWillPresenter(Context context, OldWorkWillContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getOldWorkWill(String activityName, String taskId, String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillOldWork(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<OldWorkWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(OldWorkWill s) throws Exception {
                        view.setOldWorkWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setOldWorkWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
