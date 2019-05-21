package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.CheckItem;
import com.smartbus.heze.checkup.module.CheckItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CheckItemPresenter implements CheckItemContract.presenter {

    private Context context;
    private CheckItemContract.View view;

    public CheckItemPresenter(Context context, CheckItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCheckItem() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getCheckItem().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CheckItem>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CheckItem s) throws Exception {
                        view.setCheckItem(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCheckItemMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
