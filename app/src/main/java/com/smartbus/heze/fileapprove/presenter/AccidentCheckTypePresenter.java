package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.module.AccidentCheckTypeContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.CheckType;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class AccidentCheckTypePresenter implements AccidentCheckTypeContract.presenter {

    private Context context;
    private AccidentCheckTypeContract.View view;

    public AccidentCheckTypePresenter(Context context, AccidentCheckTypeContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getAccidentCheckType(String runId, String vocationId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getAccidentCheckType(runId,vocationId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CheckType>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CheckType s) throws Exception {
                        view.setAccidentCheckType(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setAccidentCheckTypeMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
