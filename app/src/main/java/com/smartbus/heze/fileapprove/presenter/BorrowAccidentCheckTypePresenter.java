package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.module.BorrowAccidentCheckTypeContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.CheckType;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class BorrowAccidentCheckTypePresenter implements BorrowAccidentCheckTypeContract.presenter {

    private Context context;
    private BorrowAccidentCheckTypeContract.View view;

    public BorrowAccidentCheckTypePresenter(Context context, BorrowAccidentCheckTypeContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getBorrowAccidentCheckType(String runId, String vocationId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getBorrowAccidentCheckType(runId,vocationId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CheckType>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CheckType s) throws Exception {
                        view.setBorrowAccidentCheckType(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setBorrowAccidentCheckTypeMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
