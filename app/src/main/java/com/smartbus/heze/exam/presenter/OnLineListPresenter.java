package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.OnLineList;
import com.smartbus.heze.exam.module.OnLineListContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class OnLineListPresenter implements OnLineListContract.presenter {

    private Context context;
    private OnLineListContract.View view;

    public OnLineListPresenter(Context context, OnLineListContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getOnLineList(String examType,String startType,String userName) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getOnLineList(examType,startType,userName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<OnLineList>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(OnLineList s) throws Exception {
                        view.setOnLineList(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setOnLineListMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
