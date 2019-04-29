package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.Department;
import com.smartbus.heze.fileapprove.module.DepartmentContract;
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

public class DepartmentPresenter implements DepartmentContract.presenter {

    private Context context;
    private DepartmentContract.View view;

    public DepartmentPresenter(Context context, DepartmentContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getDepartment() {
        RetrofitUtil.getInstance().initRetrofitMain().getDepartment().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<Department>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(Department department) throws Exception {
                        view.setDepartment(department);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setDepartmentMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
