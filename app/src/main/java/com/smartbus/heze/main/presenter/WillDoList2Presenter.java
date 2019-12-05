package com.smartbus.heze.main.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.main.bean.WillDoList;
import com.smartbus.heze.main.module.WillDoList2Contract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @date: 2018/7/25
 * @description:
 */

public class WillDoList2Presenter implements WillDoList2Contract.presenter {

    private Context context;
    private WillDoList2Contract.View view;

    public WillDoList2Presenter(Context context, WillDoList2Contract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getWillDoList2() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillDoList2().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<WillDoList>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(WillDoList t) throws Exception {
                        view.setWillDoList2(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setWillDoList2Message("失败了----->" + e.getMessage());
                    }
                });
    }
}
