package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.module.BorrowAccidentWillCheckTypeContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.CheckType;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class BorrowAccidentWillCheckTypePresenter implements BorrowAccidentWillCheckTypeContract.presenter {

    private Context context;
    private BorrowAccidentWillCheckTypeContract.View view;

    public BorrowAccidentWillCheckTypePresenter(Context context, BorrowAccidentWillCheckTypeContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getBorrowAccidentWillCheckType(String runId, String vocationId, String destName, String mycomments) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getBorrowAccidentWillCheckType(runId,vocationId,destName,mycomments).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CheckType>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CheckType s) throws Exception {
                        view.setBorrowAccidentWillCheckType(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setBorrowAccidentWillCheckTypeMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
