package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.DJDepartment;
import com.smartbus.heze.exam.module.DJDepartmentContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class DJDepartmentPresenter implements DJDepartmentContract.presenter {

    private Context context;
    private DJDepartmentContract.View view;

    public DJDepartmentPresenter(Context context, DJDepartmentContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getDJDepartment(String depType, String demId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getDJDepartment(depType,demId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<DJDepartment>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(DJDepartment s) throws Exception {
                        view.setDJDepartment(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setDJDepartmentMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
