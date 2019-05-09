package com.smartbus.heze.main.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.main.bean.WillDoList;
import com.smartbus.heze.main.module.WillDoListContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @date: 2018/7/25
 * @description:
 */

public class WillDoListPresenter implements WillDoListContract.presenter {

    private Context context;
    private WillDoListContract.View view;

    public WillDoListPresenter(Context context, WillDoListContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getWillDoList() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillDoList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<WillDoList>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(WillDoList t) throws Exception {
                        view.setWillDoList(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setWillDoListMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
