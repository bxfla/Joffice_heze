package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.DepartBudgetWill;
import com.smartbus.heze.fileapprove.module.DepartBudgetWillContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class DepartBudgetWillPresenter implements DepartBudgetWillContract.presenter {

    private Context context;
    private DepartBudgetWillContract.View view;

    public DepartBudgetWillPresenter(Context context, DepartBudgetWillContract.View view) {
        this.context = context;
        this.view = view;
    }


    @Override
    public void getDepartBudgetWill(String activityName, String taskId, String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillDepartBudget(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<DepartBudgetWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(DepartBudgetWill s) throws Exception {
                        view.setDepartBudgetWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setDepartBudgetWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
