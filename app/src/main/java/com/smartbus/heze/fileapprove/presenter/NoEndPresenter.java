package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.NoEndPerson;
import com.smartbus.heze.fileapprove.module.NoEndContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class NoEndPresenter implements NoEndContract.presenter {

    private Context context;
    private NoEndContract.View view;

    public NoEndPresenter(Context context, NoEndContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getNoEndPerson(String taskId, String activityName, String isParentFlow) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getNoEndPerson(taskId,activityName,isParentFlow)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<NoEndPerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(NoEndPerson s) throws Exception {
                        view.setNoEndPerson(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setNoEndPersonMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
