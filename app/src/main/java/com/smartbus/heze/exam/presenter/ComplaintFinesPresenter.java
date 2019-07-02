package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.ComplaintFines;
import com.smartbus.heze.exam.module.ComplaintFinesContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class ComplaintFinesPresenter implements ComplaintFinesContract.presenter {

    private Context context;
    private ComplaintFinesContract.View view;

    public ComplaintFinesPresenter(Context context, ComplaintFinesContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getComplaintFines(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getcomplaintfines(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<ComplaintFines>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(ComplaintFines s) throws Exception {
                        view.setComplaintFines(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setComplaintFinesMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
