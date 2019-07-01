package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.ClassMileage;
import com.smartbus.heze.exam.module.ClassMileageContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class ClassMileagePresenter implements ClassMileageContract.presenter {

    private Context context;
    private ClassMileageContract.View view;

    public ClassMileagePresenter(Context context, ClassMileageContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getClassMileage(String startTime,String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getclassmileage(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<ClassMileage>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(ClassMileage s) throws Exception {
                        view.setClassMileage(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setClassMileageMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
