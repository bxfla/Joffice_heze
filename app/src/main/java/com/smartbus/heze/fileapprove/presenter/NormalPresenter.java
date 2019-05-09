package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.NormalPerson;
import com.smartbus.heze.fileapprove.module.NormalContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class NormalPresenter implements NormalContract.presenter {

    private Context context;
    private NormalContract.View view;

    public NormalPresenter(Context context, NormalContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getNormalPerson(String taskId, String activityName, String isParentFlow) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getNormalPerson(taskId,activityName,isParentFlow)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<NormalPerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(NormalPerson s) throws Exception {
                        view.setNormalPerson(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setNormalPersonMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
