package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.AddWorkWill;
import com.smartbus.heze.oaflow.module.AddWorkWillContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class AddWorkWillPresenter implements AddWorkWillContract.presenter {

    private Context context;
    private AddWorkWillContract.View view;

    public AddWorkWillPresenter(Context context, AddWorkWillContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getAddWorkWill(String activityName, String taskId, String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillAddWork(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<AddWorkWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(AddWorkWill s) throws Exception {
                        view.setAddWorkWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setAddWorkWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
