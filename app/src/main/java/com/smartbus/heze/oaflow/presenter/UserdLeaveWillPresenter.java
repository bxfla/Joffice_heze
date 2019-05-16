package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.UserdLeaveWill;
import com.smartbus.heze.oaflow.module.UserdLeaveWillContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class UserdLeaveWillPresenter implements UserdLeaveWillContract.presenter {

    private Context context;
    private UserdLeaveWillContract.View view;

    public UserdLeaveWillPresenter(Context context, UserdLeaveWillContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getUserdLeaveWill(String activityName, String taskId, String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillUserdLeave(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UserdLeaveWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(UserdLeaveWill s) throws Exception {
                        view.setUserdLeaveWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setUserdLeaveWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
