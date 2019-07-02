package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.Maintain;
import com.smartbus.heze.exam.module.MaintainContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class MaintainPresenter implements MaintainContract.presenter {

    private Context context;
    private MaintainContract.View view;

    public MaintainPresenter(Context context, MaintainContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getMaintain(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getmaintain(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<Maintain>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(Maintain s) throws Exception {
                        view.setMaintain(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setMaintainMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
