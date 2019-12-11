package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.ComparList;
import com.smartbus.heze.exam.module.ComparListContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class ComparListPresenter implements ComparListContract.presenter {

    private Context context;
    private ComparListContract.View view;

    public ComparListPresenter(Context context, ComparListContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getComparList(String startTime, String endTime, String carNo, String depId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getComparList(startTime,endTime,carNo,depId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<ComparList>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(ComparList s) throws Exception {
                        view.setComparList(s);
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setComparListMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
