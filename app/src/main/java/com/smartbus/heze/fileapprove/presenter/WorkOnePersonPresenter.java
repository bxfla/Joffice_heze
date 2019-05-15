package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.WorkOnePerson;
import com.smartbus.heze.fileapprove.module.WorkOnePersonContract;
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

public class WorkOnePersonPresenter implements WorkOnePersonContract.presenter {

    private Context context;
    private WorkOnePersonContract.View view;

    public WorkOnePersonPresenter(Context context, WorkOnePersonContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getWorkOnePerson() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWorkOnePerson().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<WorkOnePerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(WorkOnePerson workOnePerson) throws Exception {
                        view.setWorkOnePerson(workOnePerson);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setWorkOnePersonMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
