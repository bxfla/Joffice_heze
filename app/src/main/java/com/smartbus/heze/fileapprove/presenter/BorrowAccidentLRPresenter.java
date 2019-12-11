package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.BorrowAccidentLRData;
import com.smartbus.heze.fileapprove.module.BorrowAccidentLRContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class BorrowAccidentLRPresenter implements BorrowAccidentLRContract.presenter {

    private Context context;
    private BorrowAccidentLRContract.View view;

    public BorrowAccidentLRPresenter(Context context, BorrowAccidentLRContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getBorrowAccidentLR(Map<String, String> map) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getBorrowAccidentLR(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<BorrowAccidentLRData>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(BorrowAccidentLRData s) throws Exception {
                        view.setBorrowAccidentLR(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setBorrowAccidentLRMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
