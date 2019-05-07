package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.WorkPerson;
import com.smartbus.heze.fileapprove.module.WorkPersonContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class WorkPersonPresenter implements WorkPersonContract.presenter {

    private Context context;
    private WorkPersonContract.View view;

    public WorkPersonPresenter(Context context, WorkPersonContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getWorkPerson() {
        RetrofitUtil.getInstance().initRetrofitMain().getWorkPerson().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<WorkPerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(WorkPerson workPerson) throws Exception {
                        view.setWorkPerson(workPerson);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setWorkPersonMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
