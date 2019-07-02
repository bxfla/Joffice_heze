package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.SafeMileage;
import com.smartbus.heze.exam.module.SafeMileageContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class SafeMileagePresenter implements SafeMileageContract.presenter {

    private Context context;
    private SafeMileageContract.View view;

    public SafeMileagePresenter(Context context, SafeMileageContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getSafeMileage(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getsafemileage(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<SafeMileage>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(SafeMileage s) throws Exception {
                        view.setSafeMileage(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setSafeMileageMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
